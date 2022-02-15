// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract Token is ERC20("IO DBank Currency", "IDBC") {

  address public minter;

  event MinterChanged(address indexed from, address to);
  
  constructor() public payable {
    minter = msg.sender;
  }

  function passMinterRole(address dBank) public returns (bool) {
    require(msg.sender == minter, 'Error, only owner can change pass minter role');
    minter = dBank;
    emit MinterChanged(msg.sender, dBank);
    return true;
  }

  function mint(address account, uint256 amount) public {
    require(msg.sender == minter, 'Error');
		_mint(account, amount);
	}
}