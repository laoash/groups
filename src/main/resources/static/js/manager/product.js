$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get',
                url: "/prod/selProds",
                showColumns: false,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true,
                undefinedText: "-",
                dataType: "json",
                search: true,
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
                        search: params.search//页码
                    };
                },
                columns: [
                    {
                        field: 'productId',
                        title: '商品ID'
                    },
                    {
                        field: 'productName',
                        title: '商品名称'
                    },
                    {
                        field: 'marketPrice',
                        title: '市场价格'
                    },
                    {
                        field: 'productPrice',
                        title: '商品价格'
                    },
                    {
                        field: 'productImg',
                        title: '商品图片'
                    },
                    {
                        field: 'productDesc',
                        title: '商品信息'
                    },
                    {
                        field: 'productStatus',
                        title: '活动',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "正常"
                            } else if (value == 1) {
                                return "秒杀"
                            } else {
                                return "团购"
                            }
                        }
                    },
                    {
                        field: 'productDate',
                        title: '上架日期'
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
    $('#exampleTable').bootstrapTable('refresh');
}

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