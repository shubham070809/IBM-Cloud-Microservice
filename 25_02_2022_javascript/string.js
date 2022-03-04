var re = /(\w+)\s(\w+)/;
var string = "John Smith";

console.log(string);


var result = string.replace(re, '$2, $1');

console.log(result);

var var1 = "Hello World";
var stringObj = new String("Hello World");

console.log(var1);
console.log(stringObj);
console.log(stringObj.length);
console.log(stringObj.toUpperCase());
console.log(stringObj.valueOf());