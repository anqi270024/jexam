<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>试卷修改</title>

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
                <li><a href="/user/tea/add_paper"><i class="fa fa-edit"></i> 添加试卷</a></li>
                <li><a href="/user/tea/manager_paper"><i class="fa fa-edit"></i> 试卷管理</a></li>
                <li><a href="/user/tea/correct_paper"><i class="fa fa-edit"></i> 试卷批改</a></li>
                <li><a href="#"><i class="fa fa-edit"></i> 试卷修改</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 试卷修改</h3>
        </div><!-- /.navbar-collapse -->
    </nav>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <br>
                <div class="form-inline">
                    <button type="button" class="btn btn-default" id="add_single_choose">添加单选题</button>
                    <button type="button" class="btn btn-default" id="add_multi_choose">添加多选题</button>
                    <button type="button" class="btn btn-default" id="add_completion">添加填空题</button>
                    <button type="button" class="btn btn-default" id="add_short_answer">添加简答题</button>
                </div>
                <br>

                <#list exercises as item>
                    <#if  item.type == "single_choose">
                     <div class="form-group">
                         <div class="panel panel-info">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item.position!}. ${item.title!}</h3>
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
                                     分值： ${item.score!}
                                 </p>
                                 <p>
                                     备注： ${item.remark!}
                                 </p>
                             </div>
                         </div>
                     </div>

                    <#elseif item.type == "multi_choose">
                     <div class="form-group">
                         <div class="panel panel-success">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item.position!}. ${item.title!}</h3>
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
                                     分值： ${item.score!}
                                 </p>
                                 <p>
                                     备注： ${item.remark!}
                                 </p>
                             </div>
                         </div>
                     </div>
                    <#elseif item.type== "completion">
                     <div class="form-group">
                         <div class="panel panel-warning">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item.position!}. ${item.title!}</h3>
                             </div>
                             <div class="panel-body">
                                 ${item.content!}
                                 <p>
                                     分值： ${item.score!}
                                 </p>
                                 <p>
                                     备注： ${item.remark!}
                                 </p>
                             </div>
                         </div>
                     </div>
                    <#else>
                    <div class="form-group">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title">${item.position!}. ${item.title!}</h3>
                            </div>
                            <div class="panel-body">
                                ${item.content!}
                                <p>
                                    分值： ${item.score!}
                                </p>
                                <p>
                                    备注： ${item.remark!}
                                </p>
                            </div>
                        </div>
                    </div>
                    </#if>
                </#list>

            </div>
        </div>
    </div>

</div><!-- /#wrapper -->


<!-- JavaScript -->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script type="text/javascript">
    $(document).on("click", "#add_single_choose",
            function () {
                bootbox.dialog({
                    title: "添加单选题",
                    message: '<div class="row">\n' +
                    '    <div class="col-md-12">\n' +
                    '        <form class="form-horizontal" id="add_single_choose_form">\n' +
                    '            <div class="panel panel-info">\n' +
                    '                <div class="panel-heading">\n' +
                    '                    <h3 class="panel-title">\n' +
                    '                            <input type="text" class="form-control" name="title" placeholder="标题">\n' +
                    '                    </h3>\n' +
                    '                </div>\n' +
                    '                <div class="panel-body">\n' +
                    '                    <textarea class="form-control" rows="2" placeholder="内容，可为空"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        A:  <input type="text" class="form-control" name="choose-a" placeholder="选项A">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        B:  <input type="text" class="form-control" name="choose-b" placeholder="选项B">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        C:  <input type="text" class="form-control" name="choose-a" placeholder="选项C">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        D:  <input type="text" class="form-control" name="choose-b" placeholder="选项D">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        分值： <input type="number" class="form-control" name="score">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        备注： <input type="text" class="form-control" name="remark" placeholder="比如参考答案">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </form>\n' +
                    '    </div>\n' +
                    '</div>',
                    buttons: {
                        success: {
                            label: "保存",
                            className: "btn-success",
                            callback: function () {
                                var a = document.getElementById("add_pro_form");
                                a.action = "/admin/addPro.action",
                                        a.method = "post",
                                        a.submit()
                            }
                        }
                    }
                })
            }),
            $(document).on("click", "#add_multi_choose",
                    function () {
                        bootbox.dialog({
                            title: "添加多选题",
                            message: '<div class="row">\n' +
                            '    <div class="col-md-12">\n' +
                            '        <form class="form-horizontal" id="add_single_choose_form">\n' +
                            '            <div class="panel panel-success">\n' +
                            '                <div class="panel-heading">\n' +
                            '                    <h3 class="panel-title">\n' +
                            '                            <input type="text" class="form-control" name="title" placeholder="标题">\n' +
                            '                    </h3>\n' +
                            '                </div>\n' +
                            '                <div class="panel-body">\n' +
                            '                    <textarea class="form-control" rows="2" placeholder="内容，可为空"></textarea>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        A:  <input type="text" class="form-control" name="choose-a" placeholder="选项A">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        B:  <input type="text" class="form-control" name="choose-b" placeholder="选项B">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        C:  <input type="text" class="form-control" name="choose-a" placeholder="选项C">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        D:  <input type="text" class="form-control" name="choose-b" placeholder="选项D">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        分值： <input type="number" class="form-control" name="score">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        备注： <input type="text" class="form-control" name="remark" placeholder="比如参考答案">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '        </form>\n' +
                            '    </div>\n' +
                            '</div>',
                            buttons: {
                                success: {
                                    label: "保存",
                                    className: "btn-success",
                                    callback: function () {
                                        var a = document.getElementById("add_pro_form");
                                        a.action = "/admin/addPro.action",
                                                a.method = "post",
                                                a.submit()
                                    }
                                }
                            }
                        })
                    }),
            $(document).on("click", "#add_completion",
            function () {
                bootbox.dialog({
                    title: "添加填空题",
                    message: '<div class="row">\n' +
                    '    <div class="col-md-12">\n' +
                    '        <form class="form-horizontal" id="add_single_choose_form">\n' +
                    '            <div class="panel panel-warning">\n' +
                    '                <div class="panel-heading">\n' +
                    '                    <h3 class="panel-title">\n' +
                    '                            <input type="text" class="form-control" name="title" placeholder="标题">\n' +
                    '                    </h3>\n' +
                    '                </div>\n' +
                    '                <div class="panel-body">\n' +
                    '                    <textarea class="form-control" rows="2" placeholder="内容，可为空"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        A:  <input type="text" class="form-control" name="choose-a" placeholder="选项A">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        B:  <input type="text" class="form-control" name="choose-b" placeholder="选项B">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        C:  <input type="text" class="form-control" name="choose-a" placeholder="选项C">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        D:  <input type="text" class="form-control" name="choose-b" placeholder="选项D">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        分值： <input type="number" class="form-control" name="score">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        备注： <input type="text" class="form-control" name="remark" placeholder="比如参考答案">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </form>\n' +
                    '    </div>\n' +
                    '</div>',
                    buttons: {
                        success: {
                            label: "保存",
                            className: "btn-success",
                            callback: function () {
                                var a = document.getElementById("add_pro_form");
                                a.action = "/admin/addPro.action",
                                        a.method = "post",
                                        a.submit()
                            }
                        }
                    }
                })
            }),    $(document).on("click", "#add_short_answer",
            function () {
                bootbox.dialog({
                    title: "添加简答题",
                    message: '<div class="row">\n' +
                    '    <div class="col-md-12">\n' +
                    '        <form class="form-horizontal" id="add_single_choose_form">\n' +
                    '            <div class="panel panel-danger">\n' +
                    '                <div class="panel-heading">\n' +
                    '                    <h3 class="panel-title">\n' +
                    '                            <input type="text" class="form-control" name="title" placeholder="标题">\n' +
                    '                    </h3>\n' +
                    '                </div>\n' +
                    '                <div class="panel-body">\n' +
                    '                    <textarea class="form-control" rows="2" placeholder="内容，可为空"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        A:  <input type="text" class="form-control" name="choose-a" placeholder="选项A">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        B:  <input type="text" class="form-control" name="choose-b" placeholder="选项B">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        C:  <input type="text" class="form-control" name="choose-a" placeholder="选项C">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        D:  <input type="text" class="form-control" name="choose-b" placeholder="选项D">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        分值： <input type="number" class="form-control" name="score">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        备注： <input type="text" class="form-control" name="remark" placeholder="比如参考答案">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </form>\n' +
                    '    </div>\n' +
                    '</div>',
                    buttons: {
                        success: {
                            label: "保存",
                            className: "btn-success",
                            callback: function () {
                                var a = document.getElementById("add_pro_form");
                                a.action = "/admin/addPro.action",
                                        a.method = "post",
                                        a.submit()
                            }
                        }
                    }
                })
            })
</script>
</body>
</html>