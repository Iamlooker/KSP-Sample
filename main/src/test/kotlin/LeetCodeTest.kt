import com.looker.*
import org.junit.jupiter.api.Test
import solutions.Solution1491
import solutions.Solution26
import solutions.Solution58
import utils.TestSolution
import utils.testSolution

class LeetCodeTest {

    /**
     * Uses KSP generated function to test Solution
     */
    @Test
    fun test1491Ksp() {
        testSolution1491(intArrayOf(4000, 3000, 1000, 2000), 2500.00000)
    }

    @Test
    fun test26Ksp() {
        testSolution26(intArrayOf(1,1,2), 2)
        testSolution26(intArrayOf(0,0,1,1,1,2,2,3,3,4), 5)
    }

    @Test
    fun test58Ksp() {
        testSolution58("   fly me   to   the moon  ", 4)
        testSolution58("luffy is still joyboy", 6)
    }

    /**
     * Uses custom processing [testSolution]
     * It tasks the Generic types of solution class from the example type
     */
    @TestSolution(Solution1491::class)
    fun test1491() {
        testSolution {
            intArrayOf(4000, 3000, 1000, 2000) shouldOutput 2500.00000
            intArrayOf(1000, 2000, 3000) shouldOutput 2000.00000
        }
    }

    @TestSolution(Solution26::class)
    fun test26() {
        testSolution {
            intArrayOf(1,1,2) shouldOutput 2
            intArrayOf(0,0,1,1,1,2,2,3,3,4) shouldOutput 5
        }
    }

    @TestSolution(Solution58::class)
    fun test58() {
        testSolution {
            "   fly me   to   the moon  " shouldOutput 4
            "luffy is still joyboy" shouldOutput 6
        }
    }
}