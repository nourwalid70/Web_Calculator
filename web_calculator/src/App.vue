<template>

<div id="calc"> 
<div class="display1">{{expression || '0'}}</div> 
<div class="display">{{current || '0'}}</div>  
<button @click="Percent()" class="btn">&#37;</button>
<button @click="clear()" class="btn">CE</button>
<button @click="clear()" class="btn">C</button>
<button @click="del()" class="btn">DEL</button>
<button @click="Inverse()" class="btn">&#8543;x</button>
<button @click="Square()" class="btn">x&#178;</button>
<button @click="SquareRoot()" class="btn">&#8730;x</button>
<button @click="TakeOperator('÷')" class="btn">&#247;</button>
<button @click="append('7')" class="btn">7</button>
<button @click="append('8')" class="btn">8</button>
<button @click="append('9')" class="btn">9</button>
<button @click="TakeOperator('X')" class="btn">&times;</button>
<button @click="append('4')" class="btn">4</button>
<button @click="append('5')" class="btn">5</button>
<button @click="append('6')" class="btn">6</button>
<button @click="TakeOperator('-')" class="btn">&minus;</button>
<button @click="append('1')" class="btn">1</button>
<button @click="append('2')" class="btn">2</button>
<button @click="append('3')" class="btn">3</button>
<button @click="TakeOperator('+')" class="btn">&plus;</button>
<button @click="Plus_Minus()" class="btn">&#8314;/-</button>
<button @click="append('0')" class="btn">0</button>
<button @click="dot()" class="btn">.</button>
<button @click="Equale()" class="btn">&equals;</button>
</div>
</template>

<script>
   import axios from 'axios';
 export default{
   data(){
     return{
       current :'',
       previous :'',
       operator :'',
       expression :'',
       isOperand : true,
     }
   },
   methods:{

  append(number){
    if(this.isOperand){
      this.current='';
      this.expression = '';
      this.isOperand = false;
    }
   this.current = `${this.current}${number}`;
    this.expression = `${this.expression}${number}`;
  },

  TakeOperator(String){
           if(this.operator === ''){
            this.operator = String ;
            this.expression = this.expression + " " + this.operator + " ";
            this.previous = this.current;
            this.current = '';
           }   
  },

  dot(){
    if(this.current.indexOf('.') === -1){
      this.append('.');
    }
  },

  del() {
      if(this.current)
        this.current = this.current.slice(0, -1);
      if(this.expression.charAt(this.expression.length-1) === '+' || this.expression.charAt(this.expression.length-1) === '-'
          || this.expression.charAt(this.expression.length-1) === 'X' || this.expression.charAt(this.expression.length-1) === '÷'){
                  this.operator = '';
                  this.isOperand = false;
                  this.current = this.previous;
       }
         this.expression = this.expression.slice(0, -1);
    }, 

  clear(){
       this.current = '';
       this.expression = this.current;
    },

  // Single operation

 Percent(){
        axios.get('http://localhost:8060/percent', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression = this.expression + ")%" + " ";
          }.bind(this))
      },

  Inverse(){
        axios.get('http://localhost:8060/inverse', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression = this.expression + ")Pow(-1)" + " ";
          }.bind(this))
      },

  Plus_Minus(){
        axios.get('http://localhost:8060/PM', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression = this.expression + ")(-1)" + " ";
          }.bind(this))
  },

  Square(){
        axios.get('http://localhost:8060/square', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
           this.expression = this.expression + ")²" + " ";
          }.bind(this))
  },

SquareRoot(){
        axios.get('http://localhost:8060/squareR', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression = this.expression + ")√" + " ";
          }.bind(this))
},

// Double operation

 Add(){      
             axios.get('http://localhost:8060/add', {
           params: {
              first : this.previous,
              second : this.current,
      }
    })
          .then(function (response) {
             this.current=response.data; 
      }.bind(this))
    },

  Sub(){
         axios.get('http://localhost:8060/sub', {
           params: {
              first : this.previous,
              second : this.current,
      }
    })
          .then(function (response) {
             this.current=response.data; 
      }.bind(this))
  },

  Mul(){
         axios.get('http://localhost:8060/mul', {
           params: {
              first : this.previous,
              second : this.current,
      }
    })
          .then(function (response) {
             this.current=response.data; 
      }.bind(this))
  },

  Div(){
       axios.get('http://localhost:8060/div', {
           params: {
              first : this.previous,
              second : this.current,
      }
    })
          .then(function (response) {
             this.current=response.data; 
      }.bind(this))
  },

  // show result

   Equale(){
     if(this.operator === '+'){
          this.Add();
       }
    else if(this.operator === '-'){
      this.Sub();
    }
   else if(this.operator === 'X'){
     this.Mul();
   }
   else if(this.operator === '÷'){
       this.Div();
   }
   this.operator = ''; 
   },
    
   }
 }
</script>

<style>

   #calc{
     display: grid;
     font-size: 50px ;
     width: 400px;
     height: 500px;
     grid-template-columns: repeat(4,1fr) ;
     grid-auto-rows: minmax(30px,auto);
     margin: 0 auto;
     background-color: rgb(80, 9, 62);
     border-color: palevioletred;
     border-style: solid;
    }

.display1{
    text-align: left;  
   border-color: palevioletred;
   border-style: solid;
   height: 40px;
   opacity:0.5;
   font-size:30px ;
}

 .display{
   text-align: right;
 }

.display , .display1{
     grid-column: 1/5;  
     background-color: rgb(80, 9, 62);
     color: silver;
     overflow: auto;
     padding: 5px;
}

/* width */
::-webkit-scrollbar {
  width: 20px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
  border-radius: 10px;
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: rgb(173, 2, 116); 
  border-radius: 10px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #750262; 
}
  .btn{
    border: 1px solid rgba(139, 42, 118, 0.452);
    font-size: 20px;
    color: rgb(80, 9, 62);
    background: rgb(241, 162, 241); 
    outline: none; 
    margin:2px;
    font-weight: bold;
  } 
.btn:hover{
    color:rgb(241, 162, 241);
    background: rgb(80, 9, 62); 
}

</style>