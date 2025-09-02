const mongoose = require('mongoose');

async function main(){
    await mongoose.connect("mongodb+srv://parul04:hakunamatata@codeit.pngzouj.mongodb.net/Instagram");

    //schema creation
    // const userSchema = new Schema({
    //     name:String,
    //     age:Number,
    //     city:String,
    //     gender:String
    // })

    //Model create - collection creation(table create)
    //class created
    // const User = mongoose.model('user',userSchema);

    // const User1 = new User({name:"Rohit",age:22,city:"Kanpur",gender:"Female"});
    // await User1.save();

    // await User.create({name:"Rashi",city:"Mumbai",age:25});

    // await User.insertMany({name:"Arun",city:"Delhi"},{age:40,gender:"Male"});

    // const ans = await User.find({});
    // console.log(ans);

    // const ans = await User.find({name:"Rohit"});
    // console.log(ans);

}

// main()
// .then(()=>console.log("connected to DB"))
// .catch((err)=>console.log(err));

module.exports = main;