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
                        <li><a href="/course/list"><span>课程中心</span></a></li>
                        <li><a href="about-us.htm"><span>代码运行</span></a></li>
                        <li><a href="/exercise/list"><span>习题中心</span></a></li>

                    </ul>
                    <a class="btn btn-theme navbar-btn btn-default sign-in" href="/login">登录</a>
                </div>
            </div>
        </nav>
    </div>
</header>

<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="test col-md-9">
                <p>类型：</p>
                <ul class="">
                    <li class="course-nav-item on">
                        <a href="/exercise/list">全部</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=c" >C</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=cp" >C++</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=java" >JAVA</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="test col-md-9">
                <p>难度：</p>
                <ul class="">
                    <li class="course-nav-item on">
                        <a href="/exercise/list">全部</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=1" >1</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=2" >2</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=3" >3</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=4" >4</a>
                    </li>
                    <li class="course-nav-item">
                        <a href="/exercise/list?c=5" >5</a>
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
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${exe.title!}</h3>
                </div>
                <div class="panel-body">
                ${(exe.content)!}
                    <div class="form-group">
                        <#list exe.chooseList!?keys as key>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                ${key}:${exe.chooseList[key]}
                                </label>
                            </div>
                        </#list>
                    </div>
                    <hr/>
                    <h3 class="panel-title">难度系数：${exe.difficulty!}</h3>
                    <hr/>
                    <h3 class="panel-title">分&#12288;&#12288;值：${exe.score!}</h3>
                    <hr/>
                    <h3 class="panel-title">类&#12288;&#12288;型：${exe.type!}</h3>
                    <hr/>
                    <h3 class="panel-title">正&#12288;&#12288;解：${exe.answer!}</h3>
                    <hr/>
                    <h3 class="panel-title">解&#12288;&#12288;析：</h3>
                    <br>
                    <p>${exe.analysis!}</p>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="panel panel-danger">
                <#list cmt as item>
                    <div class="panel-heading">
                        <h3 class="panel-title">用户：${item.fromUserName!}</h3>
                    </div>
                    <div class="panel-body">
                        <p>
                        ${item.content!}
                        </p>
                        <small class="jmooc-date">
                            时间: ${(item.createdAt)!?string('yyyy-MM-dd')}
                        </small>
                    </div>
                </#list>
                </div>
                <form class="form-horizontal" action="/user/all/cmt/crs/add" method="post" name="cmt">
                    <textarea class="form-control" rows="3" placeholder="留言" name="content"></textarea>
                    <input type="hidden" name="fromInfo" value="${(exe.name)!}"/>
                    <input type="hidden" name="fromInfoId" value="${(exe.id)!}"/>
                    <input type="submit" class="btn btn-success jmooc-cmt" value="提交留言"/>
                </form>
            </div>
        </div>
    </div><!-- /.row -->
    <!-- Pagination -->
    <ul class="pagination">
        <li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>
        <li class="active"><a href="videos-list.htm">1 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
    </ul>
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