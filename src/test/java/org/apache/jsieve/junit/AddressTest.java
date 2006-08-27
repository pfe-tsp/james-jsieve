/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

 
package org.apache.jsieve.junit;

import javax.mail.MessagingException;

import junit.framework.TestCase;

import org.apache.jsieve.CommandManager;
import org.apache.jsieve.SieveException;
import org.apache.jsieve.TestManager;
import org.apache.jsieve.junit.commands.ThrowTestException;
import org.apache.jsieve.junit.utils.SieveMailAdapter;
import org.apache.jsieve.junit.utils.TestUtils;
import org.apache.jsieve.parser.generated.ParseException;

/**
 * Class AddressTest
 */
public class AddressTest extends TestCase
{

    /**
     * Constructor for AddressTest.
     * @param arg0
     */
    public AddressTest(String arg0)
    {
        super(arg0);
    }

    public static void main(String[] args)
    {
        junit.swingui.TestRunner.run(AddressTest.class);
    }

    /**
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
        CommandManager.resetInstance();
        TestManager.resetInstance();         
    }    

    /**
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is \"From\" \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testCaseInsensitiveHeaderName()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is \"from\" \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testTreatmentOfEmbededSpacesInHeaderName()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is \"From\" \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From ", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testOctetComparatorTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :comparator \"i;octet\" :all :is \"From\" \"uSeR@dOmAiN\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From ", "uSeR@dOmAiN");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testOctetComparatorFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :comparator \"i;octet\" :all :is \"From\" \"uSeR@dOmAiN\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From ", "user@domain");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    } 
    
    /**
     * Test for Test 'address'
     */
    public void testAsciiComparatorTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :comparator \"i;ascii-casemap\" :all :is \"From\" \"uSeR@dOmAiN\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From ", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testAsciiComparatorFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :comparator \"i;ascii-casemap\" :all :is \"From\" \"uSeR@dOmAiN\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From ", "user@domain1");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }               
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiTrue1()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            mail.getMessage().addHeader("To", "user@domain");             
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    } 
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiTrue2()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] [\"user@domain\", \"tweety@pie\"] {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            mail.getMessage().addHeader("To", "user@domain");             
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiTrue3()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] [\"user@domain\", \"tweety@pie\"] {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            mail.getMessage().addHeader("To", "tweety@pie");             
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiTrue4()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] [\"user@domain\", \"tweety@pie\"] {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            mail.getMessage().addHeader("To", "tweety@pie");             
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }                
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllMatchesTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :all :matches \"From\" \"*@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllContainsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :all :contains \"From\" \"r@dom\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartIsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :is \"From\" \"user\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartMatchesTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :matches \"From\" \"*er\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartContainsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :contains \"From\" \"r\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainIsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :is \"From\" \"domain\" {throwTestException;}";

        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainMatchesTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :matches \"From\" \"*main\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainContainsTrue()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :contains \"From\" \"dom\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "user@domain");            
            TestUtils.interpret(mail, script);
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
            isTestPassed = true;
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is \"From\" \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllMatchesFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :all :matches \"From\" \"(.*)@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllContainsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :all :contains \"From\" \"r@dom\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartIsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :is \"From\" \"user\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartMatchesFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :matches \"From\" \"(.*)er\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressLocalpartContainsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :localpart :contains \"From\" \"r\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainIsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :is \"From\" \"domain\" {throwTestException;}";

        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainMatchesFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :matches \"From\" \"(.*)main\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }    
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressDomainContainsFalse()
    {
        boolean isTestPassed = false;
        String script = "if address :domain :contains \"From\" \"dom\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "tweety@pie");            
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiFalse1()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] \"user@domain\" {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "bugs@bunny");            
            mail.getMessage().addHeader("To", "bugs@bunny");             
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    } 
    
    /**
     * Test for Test 'address'
     */
    public void testIfAddressAllIsMultiFalse2()
    {
        boolean isTestPassed = false;
        String script = "if address :all :is [\"From\", \"To\"] [\"user@domain\", \"tweety@pie\"] {throwTestException;}";
        try
        {
            SieveMailAdapter mail = (SieveMailAdapter) TestUtils.createMail();
            mail.getMessage().addHeader("From", "bugs@bunny");            
            mail.getMessage().addHeader("To", "bugs@bunny");             
            TestUtils.interpret(mail, script);
            isTestPassed = true;            
        }
        catch (MessagingException e)
        {
        }        
        catch (ThrowTestException.TestException e)
        {
        }        
        catch (ParseException e)
        {
        }
        catch (SieveException e)
        {
        }
        assertTrue(isTestPassed);
    }
    
            }