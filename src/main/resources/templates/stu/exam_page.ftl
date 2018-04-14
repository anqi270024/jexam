<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>我的考试</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/per-center.css"/>
    <link rel="stylesheet" href="/css/icon-font.min.css"/>
    <link href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet'
          type='text/css'>
</head>

<body>

<div id="wrapper">

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-bg" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="/user/stu/exercises"><i class="fa fa-plus"></i> 习题收藏</a></li>
                <li class="active-bg"><a href="/user/stu/exams"><i class="fa fa-edit"></i> 我的考试</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 我的考试</h3>
        </div><!-- /.navbar-collapse -->
    </nav>


    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>试卷名称</th>
                            <th>教师</th>
                            <th>科目</th>
                            <th>成绩</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list papers as item>
                        <td>${item.name!}</td>
                        <td>${item.teacher!}</td>
                        <td>
                            ${item.subject!}
                        </td>
                        <td>
                             <#if  item.type == 1 >
                                 <a href='/user/stu/papers/${item.id}/join'>参加考试</i></a>
                             <#elseif item.type == 2 >
                                  成绩未出
                             <#else>
                                 ${item.score!}
                             </#if>
                        </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.row -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>
</html>