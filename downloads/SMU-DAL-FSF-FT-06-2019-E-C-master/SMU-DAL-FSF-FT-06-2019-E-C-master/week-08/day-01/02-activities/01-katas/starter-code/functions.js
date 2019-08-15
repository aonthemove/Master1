function subtract(a, b){
    return a-b;
}
console.log(subtract(5,2));

function subtractorzero(a, b){
if(a-b < 0){
    return 0;
}else{
    return a-b
    
}
}
console.log(subtractorzero(10,12))

function max(a,b,c){
if(a>b && a>c){
    return a;
} else if(b>a && b>c){
    return b;
} else if(c>a && c>b){
    return c;
}
}
console.log(max(5,22,15))