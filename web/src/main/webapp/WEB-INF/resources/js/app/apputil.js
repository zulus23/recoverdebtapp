var apputil = (function () {

     var gridBorrower = function () {
         return $("#gridBorrower").kendoGrid({
             groupable: true,
             sortable: true,
             filterable: true,
             resizable: true,
             // selectable:"true",
             columnMenu: true,

             columns:[
                 {
                     title:"Должник",
                     width:"100px"

                 },
                 {
                     title:"Взыскатель",
                     width:"100px"

                 },
                 {
                     title:"Статус долга",
                     width:"100px"

                 },
                 {
                     title:"Дата начала работы",
                     width:"100px"

                 },
                 {
                     title:"Сумма долга входящая",
                     width:"100px"

                 },
                 {
                     title:"Сумма платежей с начала работы",
                     width:"100px"

                 },
                 {
                     title:"Остаток долга",
                     width:"100px"

                 },
                 {
                     title:"Адрес регистрации должника",
                     width:"100px"

                 },
                 {
                     title:"Адрес проживания должника",
                     width:"100px"

                 },

             ]
         })
     }

     return {
         gridBorrower:gridBorrower
     }


})();