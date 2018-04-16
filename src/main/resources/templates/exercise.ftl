<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <title>courses</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- CSS Files -->
    <link href="https://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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

<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="test col-md-9">
                <p>科目：</p>
                <ul class="">
                    <li class="course-nav-item on">
                        <a href="/exercises/list?type=all">全部</a>
                    </li>
                    <#list subjects as item>
                    <li class="course-nav-item">
                        <a href="/exercises/list?type=${(item.id)!}" >${(item.name)!}</a>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="test col-md-9">
                <p>题型：</p>
                <ul class="">
                    <li class="course-nav-item on">
                        <a href="/exercises/list?type=all">全部</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercises/list?type=single_choose" >单择题</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercises/list?type=multi_choose" >选择题</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercises/list?type=completion" >填空题</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercises/list?type=short_answer" >简答题</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Video list boxes: grid -->
<div class="container content content-light">
   <#--     <div class="filter">
            <a href="#" class="btn btn-theme navbar-btn btn-btn-orange">最热门</a>
            <a href="#" class="btn btn-theme navbar-btn btn-lightblue">最新更新</a>
        </div>

        <hr class="invisible" />-->
        <div class="row">
            <div class="col-lg-9">
                <#list exercises as item>
                    <#if  item.type == "single_choose">
                     <div class="form-group">
                         <div class="panel panel-info">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
                             </div>
                             <div class="panel-body">
                                 ${item.content!}
                                  <#list item.chooseList!?keys as key>
                                    <div class="form-group">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="optionsRadios">
                                                ${key}: ${item.chooseList[key]}
                                            </label>
                                        </div>
                                    </div>
                                  </#list>
                                 <p>
                                     <a class="btn btn-info" style="color:white" href="/user/stu/collect_exercises/add/${item.id!}">收藏</a>
                                 </p>
                             </div>
                         </div>
                     </div>

                    <#elseif item.type == "multi_choose">
                     <div class="form-group">
                         <div class="panel panel-success">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
                             </div>
                             <div class="panel-body">
                                 ${item.content!}
                                 <#list item.chooseList!?keys as key>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="choose">
                                                ${key}: ${item.chooseList[key]}
                                            </label>
                                        </div>
                                    </div>
                                 </#list>
                                 <p>
                                     <a class="btn btn-info" style="color:white" href="/user/stu/collect_exercises/add/${item.id!}">收藏</a>
                                 </p>
                             </div>
                         </div>
                     </div>
                    <#elseif item.type== "completion">
                     <div class="form-group">
                         <div class="panel panel-warning">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
                             </div>
                             <div class="panel-body">
                                 ${item.content!}
                                 <p>
                                     <a class="btn btn-info" style="color:white" href="/user/stu/collect_exercises/add/${item.id!}">收藏</a>
                                 </p>
                             </div>
                         </div>
                     </div>
                    <#else>
                    <div class="form-group">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
                            </div>
                            <div class="panel-body">
                                ${item.content!}
                                <p>
                                    <a class="btn btn-info" style="color:white" href="/user/stu/collect_exercises/add/${item.id!}">收藏</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    </#if>
                </#list>
            </div>
        </div><!-- /.row -->
        <!-- Pagination -->
        <ul class="pagination">
        <#if (currentPage > 1)>
            <li><a href="/exercises/list?type=${exerciseType!"all"}&page=${currentPage - 1}"><i class="fa fa-angle-left"></i></a></li>
        <#else>
            <li class="disabled"><a href="/exercises/list?type=${exerciseType!"all"}&page=${currentPage - 1}"><i class="fa fa-angle-left"></i></a></li>
        </#if>
        <#list 1..count as t>
            <#if currentPage == t>
                <li class="active"><a href="/exercises/list?type=${exerciseType!"all"}&page=${t - 1}">${t}</a></li>
            <#else>
                <li><a href="/exercises/list?type=${exerciseType!"all"}&page=${t - 1}"></a></li>
            </#if>
        </#list>
        <#if (currentPage < count)>
            <li><a href="/exercises/list?type=${exerciseType!"all"}&page=${currentPage + 1}"><i class="fa fa-angle-right"></i></a></li>
        <#else>
            <li class="disabled"><a href="/exercises/list?type=${exerciseType!"all"}&page=${currentPage + 1}"><i class="fa fa-angle-right"></i></a></li>
        </#if>
        </ul>
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