<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html class="no-js">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="<c:url value="/resources/css/main.min.css"/>" rel="stylesheet">
</head>
<body class="  ">
<div class="bg-dark dk" id="wrap">
    <div id="top">

        <!-- .navbar -->
        <header class="head">
            <div class="main-bar">
                <h3>
                    <i class="fa fa-pencil"></i>&nbsp; CRM Tool Results</h3>
            </div>
        </header>
    </div>
    <div id="left">

        <!-- #menu -->
        <ul id="menu" class="bg-blue dker">
            <li class="nav-header">Menu</li>
            <li class="nav-divider"></li>
            <li class="">
                <c:url value="/index" var="url"/>
                <a class="portfolio-box" href="<c:out value='${url}'/>">
                    <i class="fa fa-dashboard"></i><span class="link-title">&nbsp;Main Page</span>
                </a>
            </li>


            <li class="">
                <c:url value="/query" var="url"/>
                <a class="portfolio-box" href="<c:out value='${url}'/>">
                    <i class="fa fa-dashboard"></i><span class="link-title">&nbsp;Query</span>
                </a>
            </li>

            <li class="">
                <c:url value="/report" var="url"/>
                <a class="portfolio-box" href="<c:out value='${url}'/>">
                    <i class="fa fa-dashboard"></i><span class="link-title">&nbsp;Reports</span>
                </a>
            </li>

        </ul>


        </ul>
    </div>
    <div id="content">
        <div class="outer">
            <div class="inner bg-light lter">

                <div class="row">
                    <div class="col-lg-6">
                        <div class="box dark">
                            <header>
                                <div class="icons">
                                    <i class="fa fa-edit"></i>
                                </div>
                                <h5>Process output</h5>



                            </header>
                            <div id="div-1" class="body">
                                <form class="form-horizontal" action="/index" method="GET">


                                    <div class="form-group">
                                        <label for="text2" class="control-label col-lg-4">Error. Country Code or Name not specified</label>


                                    </div>

                                    <input type="hidden"
                                           name="${_csrf.parameterName}"
                                           value="${_csrf.token}"/>
                                    <div class="form-group">

                                        <label for="text2" class="control-label col-lg-4">&nbsp;&nbsp;&nbsp;</label>
                                        <div class="col-lg-8">
                                            <button type="submit" class="btn btn-primary">Return to home</button>
                                        </div>
                                    </div>


                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>





<script src="<c:url value="/resources/js/media/jquery.js"/>"></script>


<script>

</script>


</body>
</html>
