let level=document.getElementById("selectLevel");
let question=document.getElementById("question");
let showAnswereButton=document.getElementById("showAnswer");
let showAnswer=document.getElementById("answer");
let getQuestion=document.getElementById("getQuestion");

getQuestion.style.visibility="none";

level.addEventListener("change",()=>{



    fetch(`http://localhost:8080/questions/${level.value}`)
          .then(response => response.json())
          .then(data => {
    getQuestion.addEventListener("click",()=>{
        showAnswer.innerText="";
        let ques=Math.floor(Math.random() * 100);
        if(ques>data.length){
            ques=ques%10;
        }
        data.forEach(item => {
        if(item.id==ques){
        question.innerText=item.question;
        showAnswereButton.addEventListener("click",()=>{
            showAnswer.innerText=item.answer;
        })
        
        }
        });
    })
    
    
            
          })
          .catch(error => {
            // console.log('Error:', error);
          });
})