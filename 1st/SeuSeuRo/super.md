- super
    - 부모의 프로퍼티를 접근하는 키워드

    ```java
    class Object { 
    	int a;
    }
    
    class A extends Object {
    	int a;
    }
    
    public static void main(String args[]){
    	A ins = new A();
    	ins.a;
    	ins.super.a;
    }
    ```

    ```java
    class Parent {
    	int a;
    }
    
    class Child extends Parent {
    	int a;
    
    	public void myMethod() {
    		a;
    		this.a;
    		super.a;
    	}
    }
    ```

- super()
    - 부모의 생성자를 호출하는 키워드

    ```java
    class Parent {
    	int a;
    	Parent(int n) { a = n; }
    }
    
    class Child extends Parent {
    	int a;
    	Child(int n) {
    		super(n);
    		a = n;
    	}
    }
    ```