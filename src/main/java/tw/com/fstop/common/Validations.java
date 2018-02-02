
/*
 * Copyright (c) 2017, FSTOP, Inc. All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tw.com.fstop.common;

/**
 * Validation functions for business logic.
 * Throws {@link ValidateException}  when expression is false. 
 * Optional error message and business specific data can be attached to the exception object.
 * 
 *
 * @since 1.0.1
 */
public final class Validations
{

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     * Input key and error message object will be attached to the {@link ValidateException}.
     * 
     * @param expression - a boolean expression
     * @param key - attach data key
     * @param errorMessage - error message or object to attach to exception
     * @throws ValidateException if expression is false 
     */
    public static void validateArgument(boolean expression, String key, Object errorMessage) throws ValidateException
    {
        if(!expression) 
        {
            ValidateException e = new ValidateException(String.valueOf(errorMessage));
            e.set(key, errorMessage);
            throw e;
        }
    }
    
    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     * 
     * @param expression - a boolean expression
     * @param errorMessage - error message or object to attach to exception
     * @throws ValidateException if expression is false
     */
    public static void validateArgument(boolean expression, Object errorMessage) throws ValidateException
    {
        if(!expression) 
        {
            throw new ValidateException(String.valueOf(errorMessage));
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     * 
     * @param expression - a boolean expression
     * @throws ValidateException if expression is false
     */
    public static void validateArgument(boolean expression) throws ValidateException
    {
        validateArgument(expression, "");
    }
    
    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * Input key and error message object will be attached to the {@link ValidateException}.
     * 
     * @param <T> input type parameter
     * @param reference - an object reference
     * @param key - attach data key
     * @param errorMessage - error message or object to attach to exception
     * @return the non-null reference that was validated
     * @throws ValidateException if reference is null
     */    
    public static <T> T validateNotNull(T reference, String key, Object errorMessage) throws ValidateException
    {
        if (reference == null)
        {
            ValidateException e = new ValidateException(String.valueOf(errorMessage));
            e.set(key, errorMessage);
            throw e;
        }
        return reference;
    }
    
    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * 
     * @param <T> input type parameter
     * @param reference - an object reference
     * @param errorMessage - error message or object to attach to exception
     * @return the non-null reference that was validated
     * @throws ValidateException if reference is null
     */
    public static <T> T validateNotNull(T reference, Object errorMessage) throws ValidateException
    {
        if (reference == null)
        {
            throw new ValidateException(String.valueOf(errorMessage));
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * 
     * @param <T> input type parameter
     * @param reference - an object reference
     * @return the non-null reference that was validated
     * @throws ValidateException if reference is null
     */
    public static <T> T validateNotNull(T reference) throws ValidateException
    {
        return validateNotNull(reference, "");
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, 
     * but not involving any parameters to the calling method.
     * 
     * @param expression - a boolean expression
     * @param key - attach data key
     * @param errorMessage - error message or object to attach to exception
     * @throws ValidateException if expression is false
     */
    public static void validateState(boolean expression, String key, Object errorMessage) throws ValidateException
    {
        if(!expression) 
        {
            ValidateException e = new ValidateException(String.valueOf(errorMessage));
            e.set(key, errorMessage);
            throw e;
        }       
    }
    
    /**
     * Ensures the truth of an expression involving the state of the calling instance, 
     * but not involving any parameters to the calling method.
     * 
     * @param expression - a boolean expression
     * @param errorMessage - error message or object to attach to exception
     * @throws ValidateException if expression is false
     */
    public static void validateState(boolean expression, Object errorMessage) throws ValidateException
    {
        if(!expression) 
        {
            throw new ValidateException(String.valueOf(errorMessage));
        }       
    }
    
    /**
     * Ensures the truth of an expression involving the state of the calling instance, 
     * but not involving any parameters to the calling method.
     * 
     * @param expression - a boolean expression
     * @throws ValidateException if expression is false
     */
    public static void validateState(boolean expression) throws ValidateException
    {
        validateState(expression, "");
    }
    
}
