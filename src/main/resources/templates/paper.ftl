<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <title>courses</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- CSS Files -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/animate.min.css"/>
    <style type="text/css">
        a:{text-decoration:none;}
        a:link,a:visited{color:#5e5e5e;text-decoration:none;}
        a:hover{color:#F97307;text-decoration:none;}
        a:active{color:#666;text-decoration:none;}
        .test p { position: absolute; left: 0; top 0; }
        .course-nav-item{display:inline-block;margin:0 4px}
        .course-nav-item a{display:block;line-height:14px;margin-bottom:10px;padding:10px;font-size:14px}
        .course-nav-item.on a{background:#F97307;color:#fff;border-radius:2px}
    </style>
</head>
<body>
<header class="main">
    <div class="container">
        <nav class="navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><img id="logo" src="/img/logo.png" alt="jmooc" /></a>
            </div>
            <div class="collapse navbar-collapse">
                <div class="navbar-right menu-main">
                    <ul class="nav navbar-nav">

                        <li><a href="/"><span>首页</span></a></li>
                        <li><a href="/exercises/list?type=all"><span>习题中心</span></a></li>
                        <li><a href="/papers"><span>试卷中心</span></a></li>
                        <#if type == 1>
                            <li class="dropdown user-dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${name!"jmooc"}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/user/stu/exercises"><i class="fa fa-gear"></i> 习题收藏</a></li>
                                    <li><a href="/user/stu/exams"><i class="fa fa-user"></i> 我的考试</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/user/logout"><i class="fa fa-power-off"></i> 登出</a></li>
                                </ul>
                            </li>
                        <#elseif type == 2>
                            <li class="dropdown user-dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${name!"jmooc"}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/user/tea/add_subject"><i class="fa fa-user"></i> 添加科目</a></li>
                                    <li><a href="/user/tea/add_student"><i class="fa fa-user"></i> 添加学生</a></li>
                                    <li><a href="/user/tea/add_paper"><i class="fa fa-user"></i> 添加试卷</a></li>
                                    <li><a href="/user/tea/manager_paper"><i class="fa fa-user"></i> 管理试卷</a></li>
                                    <li><a href="/user/tea/correct_paper"><i class="fa fa-user"></i> 试卷批改</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/user/logout"><i class="fa fa-power-off"></i> 登出</a></li>
                                </ul>
                            </li>
                        <#else>
                            <li><a class="btn" href="/login">登录</a></li>
                            <li><a class="btn" href="/register">注册</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<!-- Video list boxes: grid -->
<div class="container content content-light">
    <div class="row">
        <div class="col-lg-9">
            <div class="table-responsive">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>试卷名称</th>
                        <th>科目</th>
                        <th>查看</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list papers as item>
                        <td>${item.name!}</td>
                        <td>
                            ${item.subject!}
                        </td>
                        <td>
                            <a href='/papers/${item.id!}'><i class="fa fa-pencil"></i></a>
                        </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div><!-- /.row -->
    <!-- Pagination -->
</div>

<footer class="main bg-dark-img">
    <section class="copyright">
        <div class="container"> &copy; Copyright 2016
        </div>
    </section>
</footer>
<!-- JavaScript Files -->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/animate.js"></script>
<script src="/js/jquery.cuteTime.min.js"></script>
<script src="/js/script.js"></script>
<!-- / JavaScript Files -->
</body>
</html>