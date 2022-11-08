const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split(' ');

let num = parseInt(input[0]);

result = '';

for (let i = 0; i < num; i++) {
  for (let j = 0; j <= i; j++) {
    result += '*';
  }
  result += '\n';
}

console.log(result);