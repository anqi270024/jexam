<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>试卷打分</title>

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
                <li class="active-bg"><a href="#"><i class="fa fa-edit"></i> 试卷打分</a></li>
            </ul>

            <h3 style="text-align: center;color: #ffffff;"> 试卷打分</h3>
        </div><!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
            <#list exercises as item>
                <#if  item.type == "single_choose">
                     <div class="form-group">
                         <div class="panel panel-info">
                             <div class="panel-heading">
                                 <h3 class="panel-title">${item_index + 1}. ${item.title!}</h3>
                             </div>
                             <div class="panel-body">
                                 ${item.content!}
                                 <div class="form-group" data-id="${item.id}">
                                     <#list item.chooseList!?keys as key>
                                                <div class="form-group">
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="answer" value="${key}">
                                                            ${key}: ${item.chooseList[key]}
                                                        </label>
                                                    </div>
                                                </div>
                                     </#list>
                                     <p>
                                         备注： ${item.remark!}
                                     </p>
                                     <p>
                                         <b>学生答案: </b>${item.studentAnswer!}
                                     </p>
                                     <p>
                                         <b>打分: </b>
                                         <select class="form-control teacher-score" data-id="${item.id}">
                                             <option value="0">0</option>
                                             <option value="${item.score}">${item.score}</option>
                                         </select>
                                     </p>
                                 </div
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
                                 <div class="form-group" data-id="${item.id}">
                                     <#list item.chooseList!?keys as key>
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" name="answer" value="${key}">
                                                                ${key}: ${item.chooseList[key]}
                                                            </label>
                                                        </div>
                                                    </div>
                                     </#list>
                                     <p>
                                         备注： ${item.remark!}
                                     </p>
                                     <p>
                                         <b>学生答案: </b>${item.studentAnswer!}
                                     </p>
                                     <p>
                                         <b>打分: </b>
                                         <select class="form-control teacher-score" data-id="${item.id}">
                                            <#list 0..item.score as t>
                                                <option value="${t}">${t}</option>
                                            </#list>
                                         </select>
                                     </p>
                                 </div
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
                                 <div class="form-group">
                                     <p>
                                         备注： ${item.remark!}
                                     </p>
                                     <p>
                                         <b>学生答案: </b>${item.studentAnswer!}
                                     </p>
                                     <p>
                                         <b>打分: </b>
                                         <select class="form-control teacher-score" data-id="${item.id}">
                                            <#list 0..item.score as t>
                                                <option value="${t}">${t}</option>
                                            </#list>
                                         </select>
                                     </p>
                                 </div
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
                                <div class="form-group">
                                    <p>
                                        备注： ${item.remark!}
                                    </p>
                                    <p>
                                        <b>学生答案: </b>${item.studentAnswer!}
                                    </p>
                                    <p>
                                        <b>打分: </b>
                                        <select class="form-control teacher-score"  data-id="${item.id}">
                                            <#list 0..item.score as t>
                                                <option value="${t}">${t}</option>
                                            </#list>
                                        </select>
                                    </p>
                                </div
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
                <div class="form-group">
                    <input type="submit" class="form-control" value="提交" id="paper-submit" onclick="exerciseSubmit()">
                </div>
            </div>
        </div>
    </div><!-- /#page-wrapper -->

</div><!-- /#wrapper -->

<!-- JavaScript -->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">

    function formPost(URL, ANSWER) {
        var temp = document.createElement("form");
        temp.action = URL;
        temp.method = "post";
        temp.style.display = "none";
        var opt = document.createElement("input");
        opt.setAttribute("name", "scores");
        opt.setAttribute("value", ANSWER);
        temp.appendChild(opt);
        document.body.appendChild(temp);
        temp.submit();
        return temp;
    }

    function exerciseSubmit() {
        var exercise_arr = $('.teacher-score');
        var res = [];
        for (var i = 0, l = exercise_arr.length; i < l; i++) {
            var obj = {
                score: $(exercise_arr[i]).val(),
                id: $(exercise_arr[i]).attr('data-id'),
            };
            res.push(obj);
        }
        var json = JSON.stringify(res);
        formPost("/user/tea/papers/${paperId}/score?student=${studentId}", json);
    }
</script>
</body>
</html>