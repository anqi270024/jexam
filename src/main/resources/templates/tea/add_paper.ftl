<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>添加试卷</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/per-center.css"/>
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
                <li><a href="/user/tea/add_subject"><i class="fa fa-bell"></i> 添加科目</a></li>
                <li><a href="/user/tea/add_student"><i class="fa fa-plus"></i> 添加学生</a></li>
                <li class="active-bg"><a href="/user/tea/add_paper"><i class="fa fa-edit"></i> 添加试卷</a></li>
                <li><a href="/user/tea/manager_paper"><i class="fa fa-edit"></i> 试卷管理</a></li>
                <li><a href="/user/tea/correct_paper"><i class="fa fa-edit"></i> 试卷批改</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 添加试卷</h3>
        </div><!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <form role="form" name="course" action="/user/tea/papers" method="post">
                    <div class="form-group">
                        <label>名称</label>
                        <input type="text" class="form-control" name="title"
                               placeholder="请输入试卷的名称">
                    </div>
                    <div class="form-group">
                        <label>科目</label>
                        <select class="form-control" name="subject">
                            <#list subjects as item>
                            <option value="${(item.id)!}">${(item.name)!}</option>
                            </#list>
                        </select>
                    </div
                    <div class="form-group">
                        <input type="submit" class="form-control" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div><!-- /#page-wrapper -->

</div><!-- /#wrapper -->

<!-- JavaScript -->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>