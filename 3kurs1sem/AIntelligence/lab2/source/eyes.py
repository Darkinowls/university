import cv2.cv2 as cv2


def see(image):
    raw_image = cv2.imread(image, 0)

    edge_detected = cv2.Canny(raw_image, 0, 0)
    # cv2.imshow('Edge', edge_detected)
    # cv2.waitKey(0)

    return edge_detected / 255
