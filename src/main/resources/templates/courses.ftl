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
                <a class="navbar-brand" href="index.html"><img id="logo" src="/img/logo.png" alt="eLearn" /></a>
            </div>
            <div class="collapse navbar-collapse">
                <div class="navbar-right menu-main">
                    <ul class="nav navbar-nav">

                        <li><a href="/"><span>首页</span></a></li>
                        <li><a href="/courses"><span>课程中心</span></a></li>
                        <li><a href="about-us.htm"><span>代码运行</span></a></li>

                        <li><a href="features.htm"><span>习题中心</span></a></li>

                        <li><a href="contact.htm"><span>联系人</span></a></li>
                    </ul>
                    <a class="btn btn-theme navbar-btn btn-default sign-in" href="#">登录</a>
                </div>
            </div>
        </nav>
    </div>
</header>

<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>课程中心</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-9">
                <h4>方向：<span class="label label-default">全部</span></h4>
                <h4>方向：<span class="label label-default">全部</span></h4>
            </div>
        </div>
    </div>
</div>

<!-- Video list boxes: grid -->
<section class="content content-light  videos-list videos-list-grid">
    <div class="container">
        <div class="filter">
            <a href="#" class="btn btn-theme navbar-btn btn-orange">所有</a> &nbsp;
            <a href="#" class="btn btn-theme navbar-btn btn-lightblue">只看本学期</a>
            <a href="#" class="btn btn-theme navbar-btn btn-lightblue">最热门</a>
            <a href="#" class="btn btn-theme navbar-btn btn-lightblue">最新更新</a>
        </div>

        <hr class="invisible" />

        <div class="row">
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
        </div>

        <div class="row">
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
            <article class="col-md-4 video-item">
                <a href="video.htm" class="video-prev video-prev-small"></a>
                <h3 class="video-title"><a href="video.htm">java从入门到精通</a></h3>
                <div class="row video-params">
                    <div class="col-md-8">
                        老师: <b>zuyi</b>
                    </div>
                    <div class="col-md-4 text-right">
                        Views: <b>312</b>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-7">
                        Date: <b>2016.12.20</b>
                    </div>
                    <div class="col-md-5 text-right">
                        参与: <b>102</b> <a href="#"><i class="fa fa-heart"></i></a>
                    </div>
                </div>
                <div class="row video-params">
                    <div class="col-md-12">
                        Category: <b>Drawing</b>
                    </div>
                </div>
            </article>
        </div>

        <!-- Pagination -->
        <ul class="pagination">
            <li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>
            <li class="active"><a href="videos-list.htm">1 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
        </ul>
    </div>
</section>

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