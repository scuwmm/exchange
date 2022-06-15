fn main() {
    println!("Hello, world!");

    let a = 100;
    let b = "b";
    println!("a is {}, b is {}", a, b);

    let c = 123;
    let mut c = 456;
    c = 789;
    println!("{}", c);


    add(100, 1);


    let d = 100;
    if d < 100 {
        println!("false")
    } else if d > 100 {
        println!("false")
    } else {
        println!("true")
    }


    let mut e = 1;
    while e != 5 {
        println!("e={}", e);
        e += 1;
    }

    let f = [1, 2, 3, 4, 5];
    for i in f.iter() {
        println!("i={}", i)
    }

    let mut g = 0;
    loop {
        if g > 5 {
            break;
        } else {
            println!("g={}",g);
            g += 1
        }
    }


    let h = String::from("HelloWorld");
    let p1 = &h[0..5];
    let p2 = &h[5..h.len()];
    println!("p1+p1={}{}",p1,p2);




    println!("END")
}


fn add(a: i32, b: i32) -> i32 {
    let r = a + b;
    println!("a+b={}", r);
    return r;
}