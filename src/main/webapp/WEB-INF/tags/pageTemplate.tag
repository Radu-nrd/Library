<%@tag description="base page template" pageEncoding="utf-8" %>
<%@attribute name="pageTitle" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${pageTitle}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/menu.css">
    </head>
    <body>
    <jsp:include page="/WEB-INF/pages/menu.jsp"/>
    <main class="container-fluid">
        <jsp:doBody/>
    </main>
    <script src="${pageContext.request.contextPath}/menuScript.js"></script>
    <script src="${pageContext.request.contextPath}/profileScript.js"></script>
    </body>
</html>