$(document).ready(function () {
    var table = $('#partTable').DataTable({
        "sAjaxSource": "/parts",
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {"mData": "id"},
            {"mData": "category"},
            {"mData": "brand"},
            {"mData": "model"},
            {"mData": "price"},
            {"mData": "stock"},
            {"mData": "realiseDate"},
            {"mData": "condition"},
            {"mData": "description"}
        ]
    })
});