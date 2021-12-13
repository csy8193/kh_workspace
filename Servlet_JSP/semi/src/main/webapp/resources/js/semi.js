// 로그인 시 유효성 검사
function loginValidate(){
    const memberId = document.getElementById("memberId");
    const memberPw = document.getElementById("memberPw");

    // 아이디가 입력되지 않은 경우
    // "아이디를 입력해주세요." 경고창 출력 후
    // 아이디 input으로 focus 이동
    if(memberId.value.trim().length == 0){
        alert("아이디를 입력해주세요");
        memberId.focus();
        return false;
    }
    if(memberPw.value.trim().length == 0){
        alert("비밀번호를 입력해주세요");
        memberPw.focus();
        return false;
    }
}


document.getElementById("idSearchBtn").addEventListener("click", () => {

    // 아이디를 입력 받을 input 요소 얻어오기
    const searchId = document.getElementById("searchId");

    // 입력 받은 아이디가 없을 경우
    if(searchId.value.trim().length == 0){
        alert("검색할 아이디를 입력해주세요.")
    }else{
        $.ajax({
            url : "member/idSearch",
            data : {"inputId" : searchId.value},

            dataType : "json", // 응답 데이터의 타입을 지정

            success : function(member){
                // console.log(member);
                // console.log(member.memberId);

                const tbody = document.getElementById("idSearchResult");
                tbody.innerHTML = "";

                if(member == null){ // 조회 결과가 없는 경우
                    
                    const tr = document.createElement("tr");
                    const td = document.createElement("td");

                    
                    // const text = document.createTextNode(inputId + " 회원이 존재하지 않습니다");
                    td.innerText = searchId.value + " 회원이 존재하지 않습니다.";

                    tr.append(td);
                    tbody.append(tr);
                    

                }else{

                    for( key in member ){
                        // console.log( key );
                        // console.log(member[key]);
                        switch(key){
                            case "memberId" :
                            case "memberName" :
                            case "memberPhone" :
                            case "memberEmail" :
                            case "memberAddress" :
                                const tr = document.createElement("tr");
                                const th = document.createElement("th");
                                const td = document.createElement("td");

                                let title; // 행 제목
                                switch(key){
                                    case "memberId" : title = "아이디"; break;
                                    case "memberName" : title = "이름"; break;
                                    case "memberPhone" : title = "전화번호"; break;
                                    case "memberEmail" : title = "이메일"; break;
                                    case "memberAddress" : title = "주소"; break;
                                }

                                th.innerText = title;
                                td.innerText = member[key];


                                tr.append(th, td);
                                tbody.append(tr);
                                

                        }
                    }

                }
            },
            error : function(request, status, error){
                console.log("ajax 통신 중 오류 발생");
                console.log(request.responseText);
            },
        });
    }

});