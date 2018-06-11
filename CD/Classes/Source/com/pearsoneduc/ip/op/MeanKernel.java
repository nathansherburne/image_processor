/***************************************************************************

  MeanKernel.java

  Written by Nick Efford.

  Copyright (c) 2000, Pearson Education Ltd.  All rights reserved.

  THIS SOFTWARE IS PROVIDED BY THE AUTHOR "AS IS" AND ANY EXPRESS OR
  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE
  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
  BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

***************************************************************************/


package com.pearsoneduc.ip.op;


/**
 * A Kernel to compute a local mean.
 *
 * @author Nick Efford
 * @version 1.1 [1999/07/29]
 */

public class MeanKernel extends StandardKernel {


  /**
   * Constructs a MeanKernel with the default dimensions of 3x3.
   */

  public MeanKernel() {
    this(3, 3);
  }

  /**
   * Constructs a MeanKernel with the specified dimensions.
   * @param w width of kernel
   * @param h height of kernel
   */

  public MeanKernel(int w, int h) {
    super(w, h, createKernelData(w, h), 4);
  }


  /**
   * Calculates normalised kernel coefficients for a mean filter.
   * @param w width of kernel
   * @param h height of kernel
   * @return array of kernel coeffients.
   */

  public static float[] createKernelData(int w, int h) {
    int n = w*h;
    float[] data = new float[n];
    float coeff = 1.0f/n;
    for (int i = 0; i < n; ++i)
      data[i] = coeff;
    return data;
  }


  /**
   * Creates a MeanKernel and prints it on standard output.
   */

  public static void main(String[] argv) {
    int w = 3, h = 3;
    if (argv.length > 1) {
      w = Integer.parseInt(argv[0]);
      h = Integer.parseInt(argv[1]);
    }
    StandardKernel kernel = new MeanKernel(w, h);
    kernel.write(new java.io.OutputStreamWriter(System.out));
  }


}