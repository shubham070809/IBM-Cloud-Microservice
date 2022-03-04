console.log('Hello, Welcome to the world of JavaScript');
 
var a=10;
var b=20;
/*NOTE 
1. In this console .log is used for printing  in the console
2. In this concatination is done by both + and comma.
2. Alert is used to create a dialouge box with a OK button by default and a predefined text*/
console.log('Sum is '+(a+b));
console.log('Sum is ',(a+b));


// Addition operator
console.log(4 + 8);

// Subtraction operator
console.log(4 - 8);

// Multiplication operator
console.log(4 * 8);

// Division operator
console.log(4 / 8);

// Modulus operator
console.log(7 % 3);

var num = 10;

console.log(num);

// Increment operator
num++; // num = num + 1

console.log(num);

var num2 = 10;

console.log(num2);

// Decrement operator
num2--; // num2 = num2 - 1

console.log(num2);


var num3 = 10;

console.log(num3);

console.log(--num3);

console.log(num3);


//==========================

// Assignment operator
var var1 = 9;
console.log(var1);

// Add Assignment operator
var var2 = 9;
var2 += 6;
console.log(var2);

// Subtract Assignment operator
var var3 = 9;
var3 -= 6;
console.log(var3);

// Multiplication Assignment operator
var var4 = 9;
var4 *= 6;
console.log(var4);

// Division Assignment operator
var var5 = 9;
var5 /= 6;
console.log(var5);

// Modulus Assignment operator
var var6 = 9;
var6 %= 6;
console.log(var6);


// ============================
//comparason operator

// It compares the var value regardless of the datatype
var var1 = 9;
var var2 = '9';

// Equal ==
// It compares the var value regardless of the datatype
console.log(var1 == var2);

// Equal ===
// It compares the var value but also checks the datatype
console.log(var1 === var2);

// Not Equal !=
console.log(var1 != var2);

// Greater than >
console.log(var1 > var2);

// Less than <
console.log(var1 < var2);

// Greater than or equal to >=
console.log(var1 >= var2);

// Less than or equal to <=
console.log(var1 <= var2);


//==============================



//conditional operator

var num1 = 100;
var num2 = 100;

var result = (num1 < num2) ? "yay" : "nay";

console.log(result);


//conditional statement

var num1 = 314;
var num2 = 314;

if (num1 < num2)
{
	console.log("Num1 is less than Num2");
}
else if (num1 > num2)
{
	console.log("Num1 is greater than Num2");
}
else
{
	console.log("Default fallback code");
}

//======================

//for in loop

var amazingObject = {frahaan: 1, b: 2, c: 3, d: 4};

for (var item in amazingObject)
{
	console.log(item + " : " + amazingObject[item]);
}


//==========================

//function


function AwesomeFunc()
{
	console.log("Hello");
	console.log("and");
	console.log("Goodbye");
}

function Sum(num1, num2)
{
	var result = num1 + num2;

	console.log(result);
}

function SumReturn(num1, num2)
{
	var result = num1 + num2;

	return result;
}

AwesomeFunc();
Sum(4, 7);
console.log(SumReturn(5, 9));

var epicVar = SumReturn(2, 100);

console.log(epicVar);











