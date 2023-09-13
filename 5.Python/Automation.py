import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
@pytest.fixture()
def browser():
    # Initialize the WebDriver (change the path to the WebDriver executable)
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    url = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/"
    driver.get(url)
    yield driver
    driver.quit()

def testca(browser):
    browser.maximize_window()

    expected_title="Want to practice test automation? Try these demo sites! | Automation Panda"
    assert expected_title in browser.title
    print("Page Title:",browser.title,"\n main page title is verified")


    speaking = browser.find_element(By.ID,"menu-item-10593")
    speaking.click()
    expectedR="Speaking | Automation Panda"
    assert expectedR==browser.title
    print("page Title:",browser.title,"\n speaking page verified")

    keynoteAddres=browser.find_element(By.CLASS_NAME,"wp-block-heading")
    assert keynoteAddres.is_displayed()
    expected ="Keynote Addresses"
    assert expected==keynoteAddres.text
    print("\n Keynote Addresses Text is verified")

    conferenceTalks=browser.find_element(By.XPATH,"//*[@id='conferences']")
    assert conferenceTalks.is_displayed()
    expectedc="Conference Talks"
    assert expectedc==conferenceTalks.text
    print("\n Conference Talks is verified")





