<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- CSS Files -->
    <link href="https://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/animate.min.css"/>

</head>
<body>
<header class="main bg-dark-img home-1">
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
        <p class="header text-center text-white">在线考试系统</p>

        <!-- Screens -->
        <div class="screens animation-domready">
            <p>
                <img src="/img/home1_tab3.png" data-animation-delay="0.5s" data-animation="fadeInUp" class="animated" alt="" />
                <img src="/img/home1_tab2.png" data-animation-delay="1.5s" data-animation="fadeInUp" class="animated" alt="" />
                <img src="/img/home1_tab1.png" data-animation-delay="2.5s" data-animation="fadeInUp" class="animated" alt="" />
            </p>
        </div>
    </div>
</header>

<div class="container content content-light home-1">
    <section class="row animation-scroll">
        <figure class="col-md-6 animated" data-animation="bounceInLeft"><img src="/img/home1_img1.png" alt="" /></figure>
        <article class="col-md-6 animated" data-animation="bounceInRight">
            <h3><strong>在线考试</strong></h3>
            <p>网上直接参与考试，无需面对面，随时随地可以考试</p>
        </article>
    </section>
    <section class="row animation-scroll">
        <article class="col-md-6 animated" data-animation="bounceInLeft">
            <h3><strong>在线判题</strong></h3>
            <p>无需传统判题，根据设置的答案智能判题，迅速可得考试成绩</p>
        </article>
        <figure class="col-md-6 animated" data-animation="bounceInRight"><img src="/img/home1_img2.png" alt="" /></figure>
    </section>
    <section class="row animation-scroll">
        <figure class="col-md-6 animated" data-animation="bounceInLeft"><img src="/img/home1_img3.png" alt="" /></figure>
        <article class="col-md-6 animated" data-animation="bounceInRight">
            <h3><strong>多种题型</strong></h3>
            <p>支持选择，填空多种题型，多种科目分类</p>
        </article>
    </section>
</div>

<footer class="main bg-dark-img">
    <section class="copyright">
        <div class="container"> &copy; Copyright 2016
        </div>
    </section>
</footer>
<!-- JavaScript Files -->
<script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="/js/animate.js"></script>
<script src="/js/jquery.cuteTime.min.js"></script>
<script src="/js/script.js"></script>
<!-- / JavaScript Files -->
</body>
</html>