import { tokens, ether, ETHER_ADDRESS, EVM_REVERT, wait } from './helpers'

const Token = artifacts.require('./Token')
const DecentralizedBank = artifacts.require('./dBank')

require('chai')
  .use(require('chai-as-promised'))
  .should()

contract('dBank', ([deployer, user]) => {
  let token, dbank
  const interestPerSecond = 31668017 //(10% APY) for min. deposit (0.01 ETH)

  beforeEach(async () => {
    token = await Token.new()
    dbank = await DecentralizedBank.new(token.address)

    await token.passMinterRole(dbank.address, {from: deployer})
  })

  describe('testing token contract...', () => {
    describe('success', () => {
      it('checking token name', async () => {
        expect(await token.name()).to.be.eq('IO DBank Currency')
      })

      it('checking token symbol', async () => {
        expect(await token.symbol()).to.be.eq('IDBC')
      })

      it('checking token initial total supply', async () => {
        expect(Number(await token.totalSupply())).to.eq(0)
      })

      it('dBank should have Token minter role', async () => {
        expect(await token.minter()).to.eq(dbank.address)
      })
    })

    describe('failure', () => {
      it('passing minter role should be rejected', async () => {
        await token.passMinterRole(user, {from: deployer}).should.be.rejectedWith(EVM_REVERT)
      })

      it('tokens minting should be rejected', async () => {
        await token.mint(user, '1', {from: deployer}).should.be.rejectedWith(EVM_REVERT) //unauthorized minter
      })
    })
  })

  describe('testing deposit...', () => {
    let balance

    describe('success', () => {
      beforeEach(async () => {
        await dbank.deposit({value: 10**16, from: user}) //0.01 ETH
      })

      it('balance should increase', async () => {
        expect(Number(await dbank.etherBalanceOf(user))).to.eq(10**16)
      })

      it('deposit time should > 0', async () => {
        expect(Number(await dbank.depositStart(user))).to.be.above(0)
      })

      it('deposit status should eq true', async () => {
        expect(await dbank.isDeposited(user)).to.eq(true)
      })
    })

    describe('failure', () => {
      it('depositing should be rejected', async () => {
        await dbank.deposit({value: 10**15, from: user}).should.be.rejectedWith(EVM_REVERT) //to small amount
      })
    })
  })
  
})