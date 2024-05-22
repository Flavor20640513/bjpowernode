function check(id,event){

    axios.get("/exam/info",
              {params:{
                        "id":id
                      }
              }
             ).then(
                          function (resp){
                              var q= resp.data;
                              var btnDom =event.target;
                              var tdDom =btnDom.parentNode;
                              var trDom=tdDom.parentNode;
                              var str="<td><input type='checkbox'></td>" +
                                  "<td><input type='text' id='id' value='"+q.id+"'/></td>" +
                                  "<td><input type='text' id='title' value='"+q.title+"'/></td>" +
                                  "<td><input type='text' id='optionA' value='"+q.optionA+"'/></td>" +
                                  "<td><input type='text' id='optionB' value='"+q.optionB+"'/></td>" +
                                  "<td><input type='text' id='optionC' value='"+q.optionC+"'/></td>" +
                                  "<td><input type='text' id='optionD' value='"+q.optionD+"'/></td>" +
                                  "<td><input type='text' id='answer' value='"+q.answer+"'/></td>" +
                                  "<td><input type='button' id='btn' value='更新' onclick='window.update()'/></td>";
                              trDom.innerHTML=str;
                          }

                    )
}
function update(){
     axios.get("/exam/update",
         { params:{
                "id":document.getElementById("id").value,
                 "title":document.getElementById("title").value,
                 "optionA":document.getElementById("optionA").value,
                 "optionB":document.getElementById("optionB").value,
                 "optionC":document.getElementById("optionC").value,
                 "optionD":document.getElementById("optionD").value,
                 "answer":document.getElementById("answer").value
             }
         }
     ).then(
         function (response){
             var result=response.data;
             if (result!=0){
                 window.location.href="/exam/find";
             }
         }
     )
}