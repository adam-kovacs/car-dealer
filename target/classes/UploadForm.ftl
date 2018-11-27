<html>
<head>
    <title>Example mail</title>
</head>
<body>
<form action="?method=PUT" method="POST" enctype="multipart/form-data">
    <table>
        <tbody>
        <tr>
            <td>Status</td>
            <td>New</td>
        </tr>
        <tr>
            <td>Subject</td>
            <td><input type="text" name="subject"
                       size="80"></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea name="content" rows="10" cols="80"></textarea></td>
        </tr>
        <tr>
            <td>Attachment</td>
            <td><input
                    name="attachment" type="file"/></td>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>