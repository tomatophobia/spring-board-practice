<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 작성</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <script type="text/javascript" src="/js/common/jquery.js"></script>
    <script type="text/javascript">
        function goCvpage(){
            location.href="/cv/cvpage";
        }

        function insertEducation(){
            $.ajax({
                url: "/cv/insertEducation",
                data: $("#educationForm").serialize(),
                dataType: "JSON",
                cache: false,
                async: true,
                type: "POST",
                success: function(obj){
                    insertEducationCallback(obj);
                },
                error: function(xhr, status, error){}
            });
        }
        function insertEducationCallback(obj){
            if(obj!= null){
                var result=obj.result;

                if(result=="success"){
                    alert("successfully updated");
                    goCvpage();
                }
                else{
                    alert("update failed");
                    return;
                }
            }
        }
    </script>
</head>
<body>
<div>
    <h2>Write new education info</h2>
    <form id="educationForm" name="educationForm">
        <table border="1px">
            <tbody>
            <tr>
                <th>Startdate</th>
                <td><input id="startdate" name="startdate" value=""/></td>
            </tr>
            <tr>
                <th>Enddate</th>
                <td><input id="enddate" name="enddate" value=""/></td>
            </tr>
            <tr>
                <th>Institute Name</th>
                <td><input id="institute" name="institute" value=""/></td>
            </tr>
            <tr>
                <th>Major</th>
                <td><input id="major" name="major" value=""/></td>
            </tr>
            <tr>
                <th>GPA</th>
                <td><input id="gpa" name="gpa" value=""/></td>
            </tr>
            <tr>
                <th>Additional Information</th>
                <td><input id="etc" name="etc" value=""/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div>
        <button type="button" onclick="javascript:goCvpage();">Home</button>
        <button type="button" onclick="javascript:insertEducation();">Submit</button>
    </div>
</div>
</body>
</html>