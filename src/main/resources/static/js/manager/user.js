$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get',
                url: "/user/selUsers",
                showColumns: false,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true,
                undefinedText: "-",
                dataType: "json",
                pagination: true,
                search: true,
                singleSelect: false,
                pageSize: 10,
                pageList: [25, 50, 100],
                pageNumber: 1,
                sidePagination: "server",
                queryParams: function (params) {
                    return {
                        limit: params.limit,//页面大小
                        offset: params.offset, //页码
                        search: params.search
                    };
                },
                columns: [
                    {
                        field: 'userId',
                        title: '会员ID'
                    },
                    {
                        field: 'userName',
                        title: '会员名称'
                    },
                    {
                        field: 'userSex',
                        title: '性别'
                    },
                    {
                        field: 'phone',
                        title: '手机号码'
                    },
                    {
                        field: 'userPhoto',
                        title: '头像'
                    },
                    {
                        field: 'province',
                        title: '省'
                    },
                    {
                        field: 'city',
                        title: '市'
                    },
                    {
                        field: 'district',
                        title: '区'
                    },
                    {
                        field: 'userAddress',
                        title: '收货地址'
                    },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var d = '<a title="删除" onclick="remove(\''
                                + row.userId
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
    var res = confirm('确定要删除选中的记录？');
    if (res == true) {
        $.ajax({
            url: "/user/delUser",
            type: "post",
            data: {
                'userid': id
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