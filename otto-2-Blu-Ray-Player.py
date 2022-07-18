# UI-test-2
# 1)Go to www.otto.de
# 2)Click in the navigation menu on "multimedia"
# 3)Click in the left navigation on "Blu-Ray-Player"
# 4)Open the first product
# 5)Validate, that the product detail page contains the string "Artikelbeschreibung"

# time management
import time

# webdriver is a set of commands that control browser
from selenium import webdriver

# import class By to choose a search method
from selenium.webdriver.common.by import By

# initialize the browser driver that starts the browser
driver = webdriver.Chrome()

# time.sleep command sets a pause of 5 sec 
time.sleep(5)

# open the URL
driver.get("https://www.otto.de")
time.sleep(5)

# press the OK button to accept cookies 
driver.find_element(By.CSS_SELECTOR, '.cookieBanner__button').click()
time.sleep(5)

# the method find_element lets us find the multimedia link, the method click lets us click it
driver.find_element(By.LINK_TEXT, "Multimedia").click()
time.sleep(5)

# the method xpath lets us find an element by xpath
driver.find_element("xpath", "//* [contains(text(), 'Blu-ray-Player')]").click()
time.sleep(5)
# search for the 1st element in the output field and click to choose it
driver.find_element(By.CSS_SELECTOR, '[data-qa="ftfind-product-1"]').click()
time.sleep(5)

# search for the text
if "Artikelbeschreibung" in driver.page_source: 
	print('Found it!') 
else: 
	print('Did not find it.') 

# close the browser window
driver.quit()



