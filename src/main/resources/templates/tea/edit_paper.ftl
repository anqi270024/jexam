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
                <li><a href="/user/tea/correct_paper"><i class="fa fa-edit"></i> 学生答卷</a></li>
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
                                 <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
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
                                <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
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
                    message: '<div class="row">\n' +
                    '    <div class="col-md-12">\n' +
                    '        <form class="form-horizontal" id="add_single_choose_form">\n' +
                    '          <input type="hidden" name="paperId" value="${paperId}">\n' +
                    '          <input type="hidden" name="subjectId" value="${subjectId}">\n' +
                    '          <input type="hidden" name="type" value="single_choose">\n' +
                    '            <div class="panel panel-info">\n' +
                    '                <div class="panel-heading">\n' +
                    '                    <h3 class="panel-title">\n' +
                    '                        <input type="text" class="form-control" name="title" placeholder="题目">\n' +
                    '                    </h3>\n' +
                    '                </div>\n' +
                    '                <div class="panel-body">\n' +
                    '                    <textarea class="form-control" rows="2" name="content" placeholder="内容"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        A:&#12288;  <input type="text" class="form-control" name="A">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        B:&#12288  <input type="text" class="form-control" name="B">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        C:&#12288;  <input type="text" class="form-control" name="C">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        D:&#12288; <input type="text" class="form-control" name="D">\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        备注: <textarea class="form-control" rows="1" name="remark"></textarea>\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="form-inline">\n' +
                    '                        分值: <input type="number" class="form-control" name="score">\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </form>\n' +
                    '    </div>\n' +
                    '</div>',
                    title: "添加单选题",
                    buttons: {
                        success: {
                            label: "保存",
                            className: "btn-success",
                            callback: function () {
                                var a = document.getElementById("add_single_choose_form");
                                a.action = "/user/tea/exercises",
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
                            '        <form class="form-horizontal" id="add_multi_choose_form">\n' +
                            '          <input type="hidden" name="paperId" value="${paperId}">\n' +
                            '          <input type="hidden" name="subjectId" value="${subjectId}">\n' +
                            '          <input type="hidden" name="type" value="multi_choose">\n' +
                            '            <div class="panel panel-success">\n' +
                            '                <div class="panel-heading">\n' +
                            '                    <h3 class="panel-title">\n' +
                            '                        <input type="text" class="form-control" name="title" placeholder="题目">\n' +
                            '                    </h3>\n' +
                            '                </div>\n' +
                            '                <div class="panel-body">\n' +
                            '                    <textarea class="form-control" rows="2" name="content" placeholder="内容"></textarea>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        A:&#12288;  <input type="text" class="form-control" name="A">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        B:&#12288;  <input type="text" class="form-control" name="B">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        C:&#12288;  <input type="text" class="form-control" name="C">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        D:&#12288;  <input type="text" class="form-control" name="D">\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        备注: <textarea class="form-control" rows="1" name="remark"></textarea>\n' +
                            '                    </div>\n' +
                            '                    <br>\n' +
                            '                    <div class="form-inline">\n' +
                            '                        分值: <input type="number" class="form-control" name="score">\n' +
                            '                    </div>\n' +
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
                                        var a = document.getElementById("add_multi_choose_form");
                                        a.action = "/user/tea/exercises",
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
                            '        <form class="form-horizontal" id="add_completion_form">\n' +
                            '          <input type="hidden" name="paperId" value="${paperId}">\n' +
                            '          <input type="hidden" name="subjectId" value="${subjectId}">\n' +
                            '          <input type="hidden" name="type" value="completion">\n' +
                            '            <div class="panel panel-warning">\n' +
                            '                <div class="panel-heading">\n' +
                            '                    <h3 class="panel-title">\n' +
                            '                        <input type="text" class="form-control" name="title" placeholder="题目">\n' +
                            '                    </h3>\n' +
                            '                </div>\n' +
                            '                <div class="panel-body">\n' +
                            '                    <textarea class="form-control" rows="2" placeholder="内容" name="content"></textarea>\n' +
                            '                    <br>\n' +
                            '                    <textarea class="form-control" rows="1" name="remark" placeholder="备注，比如答案等"></textarea>\n' +
                            '                    <br>\n' +
                            '                    <input type="number" class="form-control" name="score" placeholder="分值">\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '    </form>\n' +
                            '</div>\n' +
                            '</div>',
                            buttons: {
                                success: {
                                    label: "保存",
                                    className: "btn-success",
                                    callback: function () {
                                        var a = document.getElementById("add_completion_form");
                                        a.action = "/user/tea/exercises",
                                        a.method = "post",
                                        a.submit()
                                    }
                                }
                            }
                        })
                    }), $(document).on("click", "#add_short_answer",
            function () {
                bootbox.dialog({
                    title: "添加简答题",
                    message: '<div class="row">\n' +
                    '    <div class="col-md-12">\n' +
                    '        <form class="form-horizontal" id="add_short_answer_form">\n' +
                    '          <input type="hidden" name="paperId" value="${paperId}">\n' +
                    '          <input type="hidden" name="subjectId" value="${subjectId}">\n' +
                    '          <input type="hidden" name="type" value="short_answer">\n' +
                    '            <div class="panel panel-danger">\n' +
                    '                <div class="panel-heading">\n' +
                    '                    <h3 class="panel-title">\n' +
                    '                        <input type="text" class="form-control" name="title" placeholder="题目">\n' +
                    '                    </h3>\n' +
                    '                </div>\n' +
                    '                <div class="panel-body">\n' +
                    '                    <textarea class="form-control" rows="4" placeholder="内容" name="content"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <textarea class="form-control" rows="4" name="remark" placeholder="备注，比如答案等"></textarea>\n' +
                    '                    <br>\n' +
                    '                    <input type="number" class="form-control" name="score" placeholder="分值">\n' +
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
                                var a = document.getElementById("add_short_answer_form");
                                a.action = "/user/tea/exercises",
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