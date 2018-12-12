var temp = '';
$(function () {
    var id = '';
    getTreeData();
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get',
                url: "/user/searchUser/list",
                showColumns: false,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true,
                undefinedText: "-",
                dataType: "json",
                pagination: true,
                singleSelect: false,
                pageSize: 10,
                pageList: [25, 50, 100],
                pageNumber: 1,
                sidePagination: "server",
                queryParams: function (params) {
                    return {
                        limit: params.limit,//页面大小
                        offset: params.offset,
                        id: temp//页码
                    };
                },
                columns: [
                    {
                        field: 'categoryId',
                        title: '编号'
                    },
                    {
                        field: 'categoryName',
                        title: '名称'
                    },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var d = '<a title="删除" onclick="remove(\''
                                + row.postsId
                                + '\')"><i class="fa fa-remove" style="margin: 0"></i></a>';
                            return d;
                        }
                    }]
            });
}

/*刷新表*/
function reLoad() {
    var opt = {
        query: {
            id: temp
        }
    };
    $('#exampleTable').bootstrapTable('refresh', opt);
}

function getTreeData() {
    $.ajax({
        type: "GET",
        url: "/result/tree",
        success: function (tree) {
            loadTree(tree);
        }
    });
}

function loadTree(tree) {
    $('#jstree').jstree({
        'core': {
            'data': tree
        },
        "plugins": ["search"]
    });
    $('#jstree').jstree().open_all();
}

$('#jstree').on("changed.jstree", function (e, data) {
    if (data.selected[0] == -1) {
        temp = '';
        reLoad();
    } else {
        temp = data.selected[0];
        reLoad();
    }
});

/*删除*/
function remove(id) {
    var b = confirm('确定要删除选中的记录？');
    if (b) {
        $.ajax({
            url: "/posts/deletePosts",
            type: "post",
            data: {
                'postsId': id
            },
            success: function (r) {
                if (r.code == 0) {
                    alert(r.msg);
                    reLoad();
                } else {
                    alert(r.msg);
                }
            }
        });
    }
}

function add() {
    window.location.href = "/manager/addProduct.html"
}