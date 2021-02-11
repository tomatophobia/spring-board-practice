<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resume</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="/js/common/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            getEducation();
        });

        function registerName() {
            $.ajax({
                url: "/cv/registerName",
                data: {
                    name: $("#user_name").val()
                },
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function (obj) {
                    alert("Name registered");
                    location.reload(true);
                    location.href = location.href;
                    history.go(0);
                },
                error: function (xhr, status, error) {
                    alert("Failed to register name");
                }
            })
        }

        function deleteName() {
            $.ajax({
                url: "/cv/deleteName",
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function (obj) {
                    alert("Successfully deleted");
                    location.reload(true);
                    location.href = location.href;
                    history.go(0);
                },
                error: function (xhr, status, error) {
                    alert("Failed to delete name");
                }
            })
        }

        function goEducationWrite() {
            location.href = "/cv/educationWrite";
        }

        function getEducation() {
            $.ajax({
                url: "/cv/education",
                dataType: "JSON",
                cache: false,
                async: true,
                type: "GET",
                success: function (obj) {
                    getEducationCallback(obj);
                },
                error: function (xhr, status, error) {
                    alert("Failed to get education");
                }

            });
        }

        function deleteEducation(sequence) {
            $.ajax({
                url: "/cv/deleteEducation",
                data: {
                    seq: sequence
                },
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function (obj) {
                    deleteEducationCallback(obj);
                },
                error: function (xhr, status, error) {
                }
            });
        }

        function deleteEducationCallback(obj) {
            if (obj != null) {
                var result = obj.result;

                if (result == "success") {
                    alert("successfully deleted");
                    location.reload(true);
                    location.href = location.href;
                    history.go(0);
                } else {
                    alert("failed to delete");
                    return;
                }
            }
        }

        function getEducationCallback(obj) {
            if (obj != null) {

                var edulist = obj.list;
                var html = "";
                var html_button = "";
                if (edulist.length > 0) {
                    for (var i = 0; i < edulist.length; i++) {
                        var eduSeq = edulist[i].seq;
                        var eduStartdate = edulist[i].startdate;
                        var eduEnddate = edulist[i].enddate;
                        var eduInstitute = edulist[i].institute;
                        var eduMajor = edulist[i].major;
                        var eduGpa = edulist[i].gpa;
                        var eduEtc = edulist[i].etc;


                        html += `<table class="table table-striped"> <tr>
  <td id="period" style="width: 4rem;">
    \${eduStartdate} ~ \${eduEnddate}
  </td>
  <td id="institute" style="width: 10rem;">
    \${eduInstitute}
  </td>
</tr>
<tr>
  <td id="major">
    \${eduMajor}
  </td>
  <td id="gpa">
    \${eduGpa}
  </td>
</tr>
<tr>
  <td id="etc" colspan="2">
    \${eduEtc}
  </td>
</tr></table>
<button class="btn btn-dark" type="button" onclick="javascript:deleteEducation(\${eduSeq});">Delete</button>
<br>
`
                    }
                    $("#edu_tbody").html(html);
                    html_button += `<button class='btn btn-dark' type='button' onclick='javascript:goEducationWrite();'>New</button>`
                    $("#button").html(html_button);
                } else {
                    html += `<p>
                        Content does not exist
                    </p>
                    <button class='btn btn-dark' type='button' onclick='javascript:goEducationWrite();'>New</button>
                    `
                    $("#eduNotExist").html(html);
                }


            }

        }

        function makeAchievementsInput(self){
            $(self).parent().append('<form id="achievementsForm" name="achievementsForm">' +
                '<input id="award" name="award" placeholder="Please enter your name"/>' +
                '<input id="awardinfo" name="awardinfo" placeholder="Please enter your name"/>' +
                '<input id="club" name="club" placeholder="Please enter your name"/>' +
                '<input id="clubinfo" name="clubinfo" placeholder="Please enter your name"/>' +
                '<input id="certification" name="certification" placeholder="Please enter your name"/>' +
                '<input id="certificationinfo" name="certificationinfo" placeholder="Please enter your name"/></form>' +
                '<button type="button" class="btn btn-black" onclick="javascript:insertAchievements();">Send</button>');

        }

        function insertAchievements() {
            $.ajax({
                url: "/cv/insertAchievements",
                data: $("#achievementsForm").serialize(),
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function (obj) {
                    if (obj != null) {
                        var result = obj.result;

                        if (result == "success") {
                            alert("successfully uploaded");
                            location.reload(true);
                            location.href = location.href;
                            history.go(0);
                        } else {
                            alert("failed to upload");
                            return;
                        }
                    }
                },
                error: function (xhr, status, error) {
                }
            });
        }

        function deleteAchievements(sequence) {
            $.ajax({
                url: "/cv/deleteAchievements",
                data: {
                    seq: sequence
                },
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function (obj) {
                    if (obj != null) {
                        var result = obj.result;

                        if (result == "success") {
                            alert("successfully deleted");
                            location.reload(true);
                            location.href = location.href;
                            history.go(0);
                        } else {
                            alert("failed to delete");
                            return;
                        }
                    }
                },
                error: function (xhr, status, error) {
                }
            });
        }

    </script>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${empty userDto}">
            <input id="user_name" placeholder="Please enter your name"/>
            <button class="btn btn-dark" type="button" onclick="javascript:registerName();">Register</button>
        </c:when>
        <c:otherwise>
            <h1>${userDto.name}</h1>
            <button class="btn btn-dark" type="button" onclick="javascript:deleteName();">Delete</button>
        </c:otherwise>
    </c:choose>
</div>
<div>
    <br/>
    <h2>Education</h2>
    <br/>
    <div id="eduNotExist">

    </div>
    <div id="edu_tbody">
    </div>
    <div id="button">
    </div>
</div>
<div>
    <br/>
    <h2>Major Achievements</h2>
    <br/>
    <c:choose>
        <c:when test="${empty AchievementsList}">
            <div>
                <p>
                    Content does not exist
                </p>
                <button class="btn btn-dark" onclick="javascript:makeAchievementsInput(this);">New</button>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <button class="btn btn-dark" onclick="javascript:makeAchievementsInput(this);">New</button>
                <c:forEach var="name" items="${AchievementsList}" varStatus="status">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <td style="width: 6rem;">${name.award}</td>
                            <td style="width: 20rem;">${name.awardinfo}</td>
                        </tr>
                        <tr>
                            <td style="width: 6rem;">${name.club}</td>
                            <td style="width: 20rem;">${name.clubinfo}</td>
                        </tr>
                        <tr>
                            <td style="width: 6rem;">${name.certification}</td>
                            <td style="width: 20rem;">${name.certificationinfo}</td>
                        </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-dark" onclick="javascript:deleteAchievements(${name.seq});">Delete</button>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>


</div>

</body>
</html>
