// 각 입력 값이 유효성 검사를 진행했는지 기록할 객체
const signUpCheckObj = {
    "id" : false,
    "name" : false,
    "email" : false,
    "pwd1" : false,
    "pwd2" : false,
    "phone3" : false
}


function validate() { // 회원 가입 버튼 클릭 시 유효성 검사여부 판단

    // signUpCheckObj의 모든 값을 순차적으로 접근하여
    // false (== 유효하지 않은 경우)를 찾아내는 동작 구현

    for( key in signUpCheckObj){

        // signUpCheckObj 객체의 속성중 키가 key인 속성의 value를 얻어와
        // !를 붙여서 조건이 참인지 확인
        if(!signUpCheckObj[key]){
            let message;

            switch(key){
                case "id" : message = "아이디가 유효하지 않습니다."; break;

                case "name" : message = "이름이 유효하지 않습니다."; break;

                case "email" : message = "이메일이 유효하지 않습니다."; break;

                case "pwd1" : message = "비밀번호가 유효하지 않습니다."; break;

                case "pwd2" : message = "비밀번호가 일치하지 않습니다."; break;
                
                case "phone3" : message = "전화번호가 유효하지 않습니다."; break;

            }

            alert(message);

            // 유효하지 않은 input 요소로 포커스 이동
            document.getElementById(key).focus();

            // form태그 submit 기본 이벤트 제거
            return false;
        }
    }


}




// 아이디 유효성 검사
// - 영어 대/소문자 + 숫자, 총 6~12글자
// document.querySelector("#id")
// $("#id")

document.getElementById("id").addEventListener("input", function(e){

    const inputId = this.value;

    const regExp = /^[A-Za-z\d]{6,12}$/;

    const checkId = document.getElementById("checkId");

    if(inputId.length == 0){ // 빈칸일 경우 출력 내용 지우기
        checkId.innerText = "";
        signUpCheckObj.id = false;

    }else if(regExp.test(inputId)){ // 입력 받은 아이디가 유효하다면
        // checkId.innerText = "유효한 아이디 형식입니다";
        // checkId.style.color = "green";
        // signUpCheckObj.id = true;

        // ********************************************************************
        // AJAX를 이용한 아이디 중복 검사(비동기 통신)

        $.ajax({ // jQuery 방식의 ajax
            url : "idDupCheck", // duplication : 이중, 중복
                                                    // 어떤 Servlet을 요청할 것인가?
                                                    // 요청주소 작성 속성 (필수!!)
            data : {"inputId" : inputId},                // 요청 시 전달할 값(파라미터)
            type : "GET",
            success : function(result){
                // 비동기 통신 성공 시 수행할 동작(함수)
                // 매개변수 result : 서버로 부터 전달 받은 응답 데이터
                //                  (변수명은 자유)
                // console.log(result);
                if(result == 0){
                    checkId.innerText = "사용 가능한 아이디 입니다";
                    checkId.style.color = "green";
                    signUpCheckObj.id = true;

                }else{
                    checkId.innerText = "이미 사용중인 아이디 입니다";
                    checkId.style.color = "red";
                    signUpCheckObj.id = false;


                }
            },

            error : function(){
                // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행

            },

            complete : function(){
                // 비동기 통신이 성공하든 실패하든 통신 완료 시 마지막에 수행
                // (finally와 비슷)

            }
        })



        // ********************************************************************

    }else{
        checkId.innerText = "유효하지 않은 아이디 입니다";
        checkId.style.color = "red";
        signUpCheckObj.id = false;

    }
});


// 이름 유효성 검사
// - 한글(자+모음[+받침]), 2~5글자
$("#name").on("input", function(){
    
    const inputName = $(this).val(); // 입력 받은 이름
    const regExp = /^[가-힣]{2,5}$/;

    if( inputName.length == 0 ){ // 빈칸
        $("#checkName").text("");

        signUpCheckObj.name = false;

    }else if( regExp.test(inputName) ){ // 유효한 경우
        $("#checkName").text("유효한 이름 입니다.").css("color", "green");

        signUpCheckObj.name = true;


    }else{ // 유효하지 않은 경우
        $("#checkName").text("유효하지 않은 이름입니다.").css("color", "red");

        signUpCheckObj.name = false;

        
    }

});


// 이메일 유효성 검사
// - 아이디가 4글자 이상인 이메일 주소 형식
//  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

$("#email").on("input", function(){
    const inputEmail = $(this).val();
    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

    if( inputEmail.length == 0 ){
        $("#checkEmail").text("");
        signUpCheckObj.email = false;

    }else if(regExp.test(inputEmail)){
        // $("#checkEmail").text("유효한 이메일 입니다.").css("color", "green");
        // signUpCheckObj.email = true;

        // *********************************************************************************
        // 이메일 중복 검사(AJAX)
        $.ajax({
            url : "emailDupCheck",
            type : "GET",
            data : {"inputEmail" : inputEmail},
            success : function(result){
                if(result > 0){
                    $("#checkEmail").text("이미 사용중인 이메일입니다.").css("color", "red");

                }else{
                    $("#checkEmail").text("사용 가능합니다").css("color", "green");


                }
            },

            error : function(request, status, error){
                // console.log(request);
                // console.log(status);
                if(request.status == 404){
                    console.log("ajax 요청 주소가 올바르지 않습니다.");

                }else if(request.status == 500){
                    console.log("서버 내부 에러 발생");
                    console.log(request.responseText);
                }
                
            },
            
            complete : function(){


            }
            
        });
        // *********************************************************************************

    }else{
        $("#checkEmail").text("유효하지 않은 이메일 입니다.").css("color", "red");
        signUpCheckObj.email = false;

    }

});


// 비밀번호 유효성 검사
// - 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_) 6~20글자
// const regExp = /^[A-Za-z\d\!\@\#\-\_]{6,20}$/;
$("#pwd1").on("input", function(){
    const inputPw = $(this).val();
    const regExp = /^[A-Za-z\d\!\@\#\-\_]{6,20}$/;
    const checkPwd1 = $("#checkPwd1");

    if( inputPw.length == 0 ){
        checkPwd1.text("");
        signUpCheckObj.pwd1 = false;

    }else if(regExp.test(inputPw)){
        checkPwd1.text("유효한 비밀번호 입니다.").css("color", "green");
        signUpCheckObj.pwd1 = true;


    }else{
        checkPwd1.text("유효하지 않은 비밀번호 입니다.").css("color", "red");
        signUpCheckObj.pwd1 = false;

    }

});


// 비밀번호 확인 유효성 검사
$("#pwd2, #pwd1").on("input", function(){

    const pwd1 = document.getElementById("pwd1").value;
    const pwd2 = document.getElementById("pwd2").value;
    const checkPwd2 = document.getElementById("checkPwd2");

    if( pwd2.trim().length == 0 ){ // 비밀번호 확인이 빈칸일 경우
        checkPwd2.innerText = "";
        signUpCheckObj.pwd2 = false;

    }else if(pwd1 == pwd2){
        checkPwd2.style.color = "green";
        checkPwd2.innerText = "비밀번호가 일치합니다.";

        signUpCheckObj.pwd2 = true;

    }else{
        checkPwd2.style.color = "red";
        checkPwd2.innerText = "비밀번호가 일치하지 않습니다.";
        signUpCheckObj.pwd2 = false;

    }
});



// 전화번호 글자수 제한 + 유효성 검사
$(".phone").on("input", function(){

    // 현재 입력중인 번호 자리에 작성된 값의 길이가 4를 초과할 경우
    // -> 전화번호를 4글자 초과해서 작성함
    if( $(this).val().length > 4){

        // 글자수 제한 처리
        // -> 초과된 부분을 잘라서 없앰
        const num = $(this).val().slice(0,4); // 4자리만 남음

        // 잘라서 4자리만 남은 값을 
        // 현재 입력중인 input태그에 value로 대입
        $(this).val(num);

    }

    // 각각 입력된 번호 얻어오기
    const inputPhone2 = document.getElementById("phone2").value;
    const inputPhone3 = document.getElementById("phone3").value;

    // 정규 표현식
    const regExp2 = /^\d{3,4}$/;
    const regExp3 = /^\d{4}$/;

    // 출력용 span태그
    const checkPhone = document.getElementById("checkPhone");

    if( inputPhone2.length == 0 && inputPhone3.length == 0){ // 둘다 빈칸일 경우
        checkPhone.innerText = "";
        signUpCheckObj.phone3 = false;

    }else if(regExp2.test(inputPhone2) && regExp3.test(inputPhone3)){ // 둘다 유효
        checkPhone.innerText = "유효한 전화번호 입니다";
        checkPhone.style.color = "green";

        signUpCheckObj.phone3 = true;

    }else{ // 둘 중 하나라도 유효 X
        checkPhone.innerText = "유효하지 않는 전화번호 입니다";
        checkPhone.style.color = "red";

        signUpCheckObj.phone3 = false;

    }


});
