<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>习题收藏</title>

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
                <li class="active-bg"><a href="/user/stu/exercises"><i class="fa fa-plus"></i> 习题收藏</a></li>
                <li><a href="/user/stu/exams"><i class="fa fa-edit"></i> 我的考试</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 习题收藏</h3>
        </div><!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
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
                            </div>
                        </div>
                    </div>
                    </#if>
           </#list>
            </div>
        </div><!-- /.row -->
    </div><!-- /#page-wrapper -->

</div><!-- /#wrapper -->

<!-- JavaScript -->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>