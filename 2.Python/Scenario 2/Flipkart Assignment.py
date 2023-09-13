import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture
def browser():
    # Initialize the WebDriver (change the path to the WebDriver executable)
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    url = "https://www.flipkart.com/"
    driver.get(url)
    yield driver
    driver.quit()

def test(browser):
    browser.maximize_window()
    browser.find_element(By.CLASS_NAME,"_30XB9F").click()

    login=browser.find_element(By.XPATH,"//*[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[2]/div[2]/div/div")
    login.click()


   # login_button = browser.find_element(By.PARTIAL_LINK_TEXT,"Login")
    #assert login_button.is_displayed()
   # login_button.click()

    phonenum=browser.find_element(By.XPATH,"//*[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")
    number="9182444747"
    phonenum.send_keys(number)

    OTP=browser.find_element(By.XPATH,"/html/body/div/div/div[3]/div/div[2]/div/form/div[3]/button")
    OTP.click()

    #Request=browser.find_element(By.XPATH,"//*[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")
    #Request.click()
    #print("\n Requested")

    message=browser.find_element(By.XPATH,"/html/body/div/div/div[3]/div/div[2]/div/div/div[1]")
    phonemessage=browser.find_element(By.XPATH,"//*[@id='container']/div/div[3]/div/div[2]/div/div/div[2]/span")

    expectmsg="Please enter the OTP sent to"+ number
    actualmsg=message.text+" "+ phonemessage.text
    print(("\n popup message verified \n  Message: "+actualmsg))
    assert expectmsg==actualmsg

