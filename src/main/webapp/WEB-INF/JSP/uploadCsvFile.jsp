
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload Csv File Page</title>
</head>
<body>

     <form method="post" action="uploadFile" enctype="multipart/form-data">
         File to upload: <input type="file" name="file">

         Name: <input type="text" name="name">

         <input type="submit" value="Upload"> Press here to upload the file!
     </form>

</body>
</html>
