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
<button @click="Div()" class="btn">&#247;</button>
<button @click="append('7')" class="btn">7</button>
<button @click="append('8')" class="btn">8</button>
<button @click="append('9')" class="btn">9</button>
<button @click="Mul()" class="btn">&times;</button>
<button @click="append('4')" class="btn">4</button>
<button @click="append('5')" class="btn">5</button>
<button @click="append('6')" class="btn">6</button>
<button @click="Sub()" class="btn">&minus;</button>
<button @click="append('1')" class="btn">1</button>
<button @click="append('2')" class="btn">2</button>
<button @click="append('2')" class="btn">3</button>
<button @click="Add()" class="btn">&plus;</button>
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
       result :'',
       operator :'',
       expression :'',
       isOperand : true,
     }
   },
   methods:{

  append(number){
    if(this.isOperand){
      this.current='';
      this.isOperand = false;
    }
    this.current = `${this.current}${number}`;
    this.expression = this.current;
  },

  dot(){
    if(this.current.indexOf('.') === -1){
      this.append('.');
    }
  },

  del() {
      if(this.current)
        this.current = this.current.slice(0, -1);
        this.expression = this.current;
    }, 

  clear(){
       this.current = '';
       this.expression = this.current;
    },

  // Single operation

 Percent(){
        var reset = this.current;
        axios.get('http://localhost:8060/percent', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression =this.expression.replace(reset,this.current);
            this.result=this.current
          }.bind(this))
      },

  Inverse(){
       var temp = this.current;
        axios.get('http://localhost:8060/inverse', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression =this.expression.replace(temp,this.current);
            this.result=this.current
          }.bind(this))
      },

  Plus_Minus(){
        var temp = this.current;
        axios.get('http://localhost:8060/PM', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression =this.expression.replace(temp,this.current);
            this.result=this.current
          }.bind(this))
  },

  Square(){
        var temp = this.current;
        axios.get('http://localhost:8060/square', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression =this.expression.replace(temp,this.current);
            this.result=this.current
          }.bind(this))
  },

SquareRoot(){
      var temp = this.current;
        axios.get('http://localhost:8060/squareR', {
          params: {
                first: this.current
              }
            })
          .then(function (response) {
            this.current=response.data;
            this.expression =this.expression.replace(temp,this.current);
            this.result=this.current
          }.bind(this))
},

// Double operation
  
    Add(){
      axios.get('http://localhost:8060/add', {
    params: {
      first : "5",
      second : "3",
    }
  })
  .then(function (response) {
    console.log(response.data);
  }.bind())
    },

   Sub(){

   },

   Mul(){

   },

  Div(){

  },
   
  // show result

   Equale(){
     
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
    }

.display1{
    text-align: left;  
   border-color: palevioletred;
   border-style: solid;
   height: 40px;
   padding: 5px;
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
     overflow: hidden;
}

  .btn{
    border: 1px solid rgba(139, 42, 118, 0.452);
    font-size: 20px;
    color: rgb(80, 9, 62);
    background: rgb(241, 162, 241); 
    outline: none; 
    margin: 3px;
    font-weight: bold;
  } 
.btn:hover{
    color:rgb(241, 162, 241);
    background: rgb(80, 9, 62); 
}

</style>