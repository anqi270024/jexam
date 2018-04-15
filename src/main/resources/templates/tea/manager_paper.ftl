<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>试卷管理</title>

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
                <li class="active-bg"><a href="/user/tea/manager_paper"><i class="fa fa-edit"></i> 试卷管理</a></li>
                <li><a href="/user/tea/correct_paper"><i class="fa fa-edit"></i> 学生答卷</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 试卷管理</h3>
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
                            <th>科目</th>
                            <th>删除</th>
                            <th>编辑</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list papers as item>
                        <td>${item.name!}</td>
                        <td>
                            ${item.subject!}
                        </td>
                        <td>
                            <a class="delete" role="button" href="/user/tea/papers/${item.id}/delete"
                               data-title="删除试卷" data-text="确定删除?" data-confirm-button="是"
                               data-cancel-button="否"><i class="fa fa-trash-o"></i></a>
                        </td>
                        <td>
                            <a href='/user/tea/papers/${item.id}/edit'><i class="fa fa-pencil"></i></a>
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
<script src="/js/jquery.confirm.min.js"></script>
<script type="text/javascript">
    $(".delete").confirm();
</script>
</body>
</html>