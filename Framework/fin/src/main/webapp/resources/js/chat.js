/* 
let chattingSock = new SockJS("<c:url value='/chat' />");

const memberNo = "${loginMember.memberNo}";
const memberId = "${loginMember.memberId}";
const memberName = "${loginMember.memberName}";
const chatRoomNo = "${chatRoomNo}";

const contextPath = "${contextPath}"; 
*/

function sendMessage(){
    const message = $("#inputChatting").val();
    if(message.trim().length == 0){
        alert("내용을 입력해주세요");

    }else{

        const obj = {}
        obj.memberNo = memberNo;
        obj.memberId = memberId;
        obj.memberName = memberName;
        obj.message = message;
        obj.chatRoomNo = chatRoomNo;

        // console.log(obj);

        // 만들어진 JS 객체를 JSON으로 변환하여 웹소켓 객체 handleTextMessage() 로 전달

        // JSON.stringify : JS 객체 -> JSON 문자열
        // JSON.parse : JSON 문자열 -> JS 객체
        chattingSock.send(JSON.stringify(obj));

        $("#inputChatting").val(""); // 전달된 메시지 지우기

    }
}

chattingSock.onmessage = function(e) {
    console.log(JSON.parse(e.data));

    // 메소드를 통해 전달받은 객체값을 JSON객체로 변환해서 obj 변수에 저장.
   const obj = JSON.parse(e.data);


   const li = $("<li>");


   const p = $("<p class='chat'>");
   const span = $("<span class='chatDate'>");
   span.html(obj.createDate);

   // const chat = obj.message.replace(/\\n/g, "<br>");
   // p.html(chat);
   
   if(obj.message != undefined){ // 메시지가 있는 경우
       // XSS, 개행문자 처리
       let chat = XSS(obj.message);
    
       chat = chat.replaceAll("\n", "<br>");
       p.html(chat);
   }else{ // 메시지가 없는 경우(나가기)
        p.html("<b>"+obj.memberName+"님이 나가셨습니다.</b>")

   }


   if (obj.memberNo == memberNo) {
      li.addClass("myChat");
      li.append(span);
      li.append(p);
   } else {
      li.html("<b>" + obj.memberName + "</b><br>");
      li.append(p);
      li.append(span);
   }


   $(".display-chatting").append(li);

   // 채팅 입력 시 스크롤을 가장 아래로 내리기
   $(".display-chatting").scrollTop($(".display-chatting")[0].scrollHeight);
}


// 보내기 버튼 클릭 시 채팅 전달
$("#send").on("click", sendMessage);




// XSS 처리 함수
function XSS(message){
    let str = message;

    str = str.replace(/&/g, "&amp;");
    str = str.replace(/</g, "&lt;");
    str = str.replace(/>/g, "&gt;");
    str = str.replace(/"/g, "&quot;");

    return str;
}

//----------------------------------------------------------------------------------
// 나가기 버튼 동작
$("#exit-btn").on("click", function(){
    if(confirm("나가시겠습니까?")){
        
        const obj = {};
        obj.memberNo = memberNo;
        obj.chatRoomNo = chatRoomNo;
        obj.memberName = memberName;

        // 웹소켓 처리 객체로 전달(Object -> JSON)
        chattingSock.send(JSON.stringify(obj));

        // 방 나가기
        // location.replace : 해당 주소 화면으로 화면을 변경(이전 화면이 히스토리에 남지 않음)
        //                          --> 뒤로가기 불가
        location.replace(contextPath + "/chat/roomList");
    }
});