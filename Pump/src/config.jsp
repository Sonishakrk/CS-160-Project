<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    </head>

    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="container">

            <h2>Gas Station</h2>
            <div class="col-md-6 col-md-offset-3">
                <div class="sales" role="alert">
                </div>

                    <div class="fuel-group">
                        <label for="transaction">Deposit</label> <input type="number" class="fuel-control" id="transaction"  required>
                    </div>

                    <div class="fuel-group">
                        <label for="transaction">Change</label> <input type="number" class="fuel-control" id="transaction"required>
                    </div>

                    <div class="fuel-group">
                        <label for="transaction">Sales</label> <input type="number" class="fuel-control" id="transaction"  required>
                    </div>

                    <div class="fuel-group">
                        <label for="transaction">Number</label> <input type="number" class="fuel-control" id="transaction" required>
                    </div>

                    <button type="clear" class="btn btn-primary">clear</button>

                </form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>

    </html>