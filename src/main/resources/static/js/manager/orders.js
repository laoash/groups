$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get',
                url: "/orders/selOrders",
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
                        offset: params.offset, //页码
                        search: params.search
                    };
                },
                columns: [
                    {
                        field: 'orderId',
                        title: '订单ID'
                    },
                    {
                        field: 'user',
                        title: '会员名称',
                        formatter: function (value, row, index) {
                            return value.userName;
                        }
                    },
                    {
                        field: 'user',
                        title: '联系方式',
                        formatter: function (value, row, index) {
                            return value.phone;
                        }
                    },
                    {
                        field: 'user',
                        title: '收货地址',
                        formatter: function (value, row, index) {
                            return value.userAddress;
                        }
                    },
                    {
                        field: 'user',
                        title: '支付状态',
                        formatter: function (value, row, index) {
                            if (value.payStatus == 0) {
                                return "未支付";
                            } else {
                                return "已支付";
                            }
                        }
                    },
                    {
                        field: 'orderDate',
                        title: '订单日期'
                    },
                    {
                        field: 'totalPrice',
                        title: '订单总价'
                    },
                    {
                        field: 'orderStatus',
                        title: '订单状态',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "取消订单";
                            } else {
                                return "已接单";
                            }
                        }
                    },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a title="查看订单详情" onclick="item(\''
                                + row.orderId
                                + '\')"><i class="fa fa-eye" style="margin: 0"></i></a>&nbsp;&nbsp;&nbsp;';
                            var d = '<a title="删除" onclick="remove(\''
                                + row.orderId
                                + '\')"><i class="fa fa-remove" style="margin: 0"></i></a>';
                            return e + d;
                        }
                    }]
            });
}

/*刷新表*/
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

/*订单详情*/
function item(id) {
    window.location.href = "/orderItem/selOrderItem?orderId=" + id;
}

/*删除*/
function remove(id) {
    var res = confirm('确定要删除选中的记录？');
    if (res == true) {
        $.ajax({
            url: "/orders/delOrders",
            type: "post",
            data: {
                'orderId': id
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