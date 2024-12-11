pragma solidity ^0.8.0;

contract HelloWorld {

    string private _greeting;

    constructor () {
        _greeting = "Hello, World!";
    }   


    function greet() external view 
    returns (string memory) {
        return _greeting;
    }

    function setGreeting(string calldata greeting) external {
        _greeting = greeting;
    }

}