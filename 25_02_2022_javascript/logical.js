var var1 = false;
var var2 = false;

// AND operator &&
console.log(var1 && var2);

// OR operator ||
console.log(var1 || var2);

// NOT operator !
console.log(!var1);


var num1 = 9;
var num2 = 10;
var num3 = 11;
var num4 = 11;

console.log((num1 < num2) && (num3 == num4));

for (var i = 0; i <= 100; i += 2)
{
	if (i === 50)
	{
		//break;
		continue;
	}

	console.log("This is position for I: " + i);
}