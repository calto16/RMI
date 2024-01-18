
def min_moves(A, B):
    moves = 0
    diff = abs(A - B)
    if diff == 0:
        return 0
    if diff&1:
        val = 1
        while 1:
            if (val* (val+1) ) >= 2*diff:
                return val
            val += 1
            if (val* (val+1) ) >= 2*diff:
                return val 
            val += 3

    else:
        val = 3
        while 1:
            if (val* (val+1) ) >= 2*diff:
                return val
            val += 1
            if (val* (val+1) ) >= 2*diff:
                return val 
            val += 3


n = int(input())
for i in range(n):
  A, B = map(int, input().split())
  print(min_moves(A, B))