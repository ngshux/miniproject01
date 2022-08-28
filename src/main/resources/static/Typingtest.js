const typingText = document.querySelector(".typing-text p"),
inpField = document.querySelector(".wrapper .input-field");
mistakeTag = document.querySelector(".mistake span");
wpmTag = document.querySelector(".wpm span");
cpmTag = document.querySelector(".cpm span");
timeTag = document.querySelector(".time span b");
tryAgainBtn = document.querySelector(".reset");

let timer,
maxTime = 60,
timeLeft = maxtime,
charIndex = mistakes = isTyping = 0;

function separateLetters(){
    typingText.innerHTML = "";
    document.getElementById("generated-poem").innerHTML.split("").array.forEach(element => {
        let spanTag = `<span>${element}</span>`;
        typingText.innerHTML += spanTag;
    });
    typingText.querySelectorAll("span")[0].classList.add("active");
    document.addEventListener("keydown", () => inpField.focus());
    typingText.addEventListener("click", () => inpField.focus());
}

function initTimer(){
    if(timeLeft>0){
        timeLeft--;
        timeTag.innerText = timeLeft;
    }else{
        clearInterval(timer);
    }
}

function initTyping(){
    const characters = typingText.querySelectorAll("span");
    let typedChar = inpField.value.split("")[charIndex];
    if(charIndex < characters.length - 1 && timeLeft >0){
        if(!isTyping){
            timer= setInterval(initTimer, 1000);
            isTyping = true;
        }
        
        if(typedChar ==null){
            charIndex--;
            if(characters[charIndex].classList.contains("incorrect"))
                mistakes--;
            characters[charIndex].classList.remove("correct","incorrect");
        }else{
            if(characters[charIndex].innerText  === typedChar){
                characters[charIndex].classList.add("correct");
            }else{
                mistakes++;
                characters[charIndex].classList.add("incorrect");
            }
            charIndex++;
        }
        characters.forEach(span => span.classList.remove("active"));
        characters[charIndex].classList.add("active");
    
        //average of 5 char per word
        let wpm = Math.round((((charIndex - mistakes) / 5) / (maxTime - timeLeft)) *60);
        wpm = wpm<0 || !wpm || wpm === Infinity?0 :wpm;
        
        mistakeTag.innerText = mistakes;
        cpmTag.innerText = charIndex - mistakes;
        wpmTag.innerText = wpm;
    } else{
        inpField.value = "";
        clearInterval(timer);
    }
}

function resetGame(){
    separateLetters();
    inpField.value = "";
    clearInterval(timer);
    timeLeft = maxTime,
    charIndex = mistakes = isTyping = 0;
    timeTag.innerText = timeLeft;
    mistakeTag.innerText = mistakes;
    wpmTag.innerText = 0;
    cpmTag.innerText = 0;
}

separateLetters();
inpField.addEventListener("input", initTyping);
tryAgainBtn.addEventListener("click", resetGame);
